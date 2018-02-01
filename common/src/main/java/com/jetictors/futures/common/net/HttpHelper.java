package com.jetictors.futures.common.net;

import android.content.Context;
import android.text.TextUtils;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jetictors.futures.common.Constants;
import com.jetictors.futures.common.utils.AppContext;
import com.jetictors.futures.common.utils.AppUtil;
import com.jetictors.futures.common.utils.SPHelper;
import com.jetictors.futures.common.utils.file.FileUtil;
import com.jetictors.futures.common.utils.logger.KLog;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 创建者：邓浩宸
 * 时间 ：2016/11/15 15:59
 * 描述 ：网络请求的辅助类
 */
public class HttpHelper implements IDataHelper {

    private static final String TAG = HttpHelper.class.getSimpleName();

    private static NetConfig netConfig = new NetConfig();

    private HashMap<String, Object> mServiceMap;

    private static OkHttpClient okHttpClient = null;

    private static Retrofit retrofit = null;

    public static Context context;

    private Gson gson;


    public HttpHelper(Context context) {
        //Map used to store RetrofitService
        mServiceMap = new HashMap<>();
        this.context = context;
    }

    @Override
    public void initConfig(NetConfig netConfig) {
        this.netConfig = netConfig;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> S getApi(Class<S> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createApi(serviceClass);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> S getApi(Class<S> serviceClass, OkHttpClient client) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createApi(serviceClass, client);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

    @Override
    public <S> S createApi(Class<S> serviceClass) {
        return createApi(serviceClass, getOkHttpClient());
    }

    @Override
    public <S> S createApi(Class<S> serviceClass, OkHttpClient client) {
        String baseURL = (String) SPHelper.get(AppContext.get(), "BaseUrl", "");
        if (TextUtils.isEmpty(baseURL)) {
            try {
                Field field1 = serviceClass.getField("baseURL");
                baseURL = (String) field1.get(serviceClass);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.getMessage();
                e.printStackTrace();
                System.out.println(" e.getMessage()"+ e.getMessage());
            }
            if(TextUtils.isEmpty(baseURL)){
                baseURL= Constants.UrlManager.BASE_URL;
            }

        }else{
            baseURL= "http://"+baseURL +"/";
        }
        System.out.println("baseURL"+baseURL);
        if (retrofit != null && retrofit.baseUrl().host() == baseURL) {
            KLog.d(retrofit.baseUrl().host() + "    " + retrofit.baseUrl().toString() + "    " + baseURL);
            return retrofit.create(serviceClass);
        } else {
            return getRetrofit(baseURL).create(serviceClass);
        }
    }

    @Override
    public OkHttpClient getClient() {
        if (okHttpClient != null) {
            return okHttpClient;
        } else {
            return getOkHttpClient();
        }
    }

    public Gson getGson() {
        if (gson == null){
            gson = new GsonBuilder().create();//Gson解析
        }

        return gson;
    }

    /**
     * 如果是需要返回String的数据是使用
     *
     * @return Retrofit
     */
    public Retrofit getRetrofit(String host) {
        if (gson == null){
            gson = getGson();//Gson解析
        }

        if (okHttpClient == null){
            okHttpClient = getOkHttpClient();
        }

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(host);//baseurl路径
        builder.client(okHttpClient)//添加客户端
                .addConverterFactory(new StringConverterFactory())//添加Gson格式化工厂
                .addConverterFactory(GsonConverterFactory.create(gson));//添加Gson格式化工厂
        if (netConfig.isUseRx) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());//call 适配器
        }
        retrofit = builder.build();
        return retrofit;
    }


    public OkHttpClient getOkHttpClient() {
        ClearableCookieJar cookieJar =//对cooke自动管理管理
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        File cacheFile = new File(FileUtil.getCacheDirectory(context), "OkHttp");//缓存路径
        cacheFile = FileUtil.makeDirs(cacheFile);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 40);//设置缓存大小为40M
        //缓存
        CacheInterceptor cacheInterceptor = new CacheInterceptor(context);
        //token管理
        TokenInterceptor tokenInterceptor = new TokenInterceptor();
        // https://drakeet.me/retrofit-2-0-okhttp-3-0-config
        OkHttpClient.Builder builder =
                new OkHttpClient.Builder()
                        .cache(cache)
                        .addInterceptor(cacheInterceptor)
                        .addInterceptor(tokenInterceptor)
                        .addNetworkInterceptor(cacheInterceptor)
                        //                        .retryOnConnectionFailure(true)
                        .connectTimeout(netConfig.connectTimeoutMills != 0 ? netConfig.connectTimeoutMills : 15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)//写超时超时
                        .readTimeout(netConfig.readTimeoutMills != 0 ? netConfig.readTimeoutMills : 15, TimeUnit.SECONDS);//读超时
//                        .cookieJar(netConfig.mCookieJar != null ? netConfig.mCookieJar : cookieJar);
        if (AppUtil.isDebug()) {//如果当前是debug模式就开启日志过滤器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置https相关
        if (netConfig.mHttpsCall != null) {
            netConfig.mHttpsCall.configHttps(builder);
        }
        if (netConfig.call != null) {
            builder.addInterceptor(new CallInterceptor(netConfig.call));
        }
        if (netConfig.mInterceptors != null) {
            for (int i = 0; i < netConfig.mInterceptors.length; i++) {
                builder.addInterceptor(netConfig.mInterceptors[i]);
            }

        }
        //当前okHttpClient
        okHttpClient = builder.build();

        return okHttpClient;
    }

}
