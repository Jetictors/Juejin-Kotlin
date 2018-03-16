package com.jetictors.futures.yake.utils

import java.util.regex.Pattern

/**
 * 描述    : 为String类型添加一些扩展方法
 * author  : Jetictors
 * time    :  2018/1/24 13:01
 * version : v1.0.1
 */


/**
 * 验证当前参数值是否是一个正确的手机号码
 * @return boolean
 */
fun String.isPhoneNum() : Boolean{
    val REGEX_PHONE = "[1][34578]\\\\d{9}"
    return Pattern.matches(REGEX_PHONE,this)
}

/**
 * 验证密码长度
 * @param length 最小的密码长度
 * @return boolean
 */
fun String.isPwd(length : Int) = this.length >= length

/**
 * 验证密码长度
 * @param minLength 最小密码长度
 * @param maxLength 最大密码长度
 * @return boolean
 */
fun String.isPwd(minLength : Int, maxLength : Int) = this.length in minLength..(maxLength - 1)

/**
 * 验证当前参数值是否是一个正确的邮箱
 * @return boolean
 */
fun String.isEmail() : Boolean{
    val REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
    return Pattern.matches(REGEX_EMAIL,this)
}

/**
 * 验证当前参数值是否全部由数字组成
 * @return boolean
 */
fun String.isPureNum() : Boolean = false







