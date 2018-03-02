package com.jetictors.futures.yake.utils

/**
 * 描述    : 为String类型添加一些扩展方法
 * author  : Jetictors
 * time    :  2018/1/24 13:01
 * version : v1.0.1
 */


/**
 * 验证当前参数值是否是一个正确的手机号码
 * @param phoneNum 手机号码
 * @return boolean
 */
fun String.isPhoneNum(phoneNum : String) = false

/**
 * 验证密码长度
 * @param pwd 密码
 * @param length 最小的密码长度
 * @return boolean
 */
fun String.isPwd(pwd : String, length : Int) = pwd.length >= length

/**
 * 验证密码长度
 * @param pwd 密码
 * @param minLength 最小密码长度
 * @param maxLength 最大密码长度
 * @return boolean
 */
fun String.isPwd(pwd: String, minLength : Int, maxLength : Int) = pwd.length in minLength..(maxLength - 1)

/**
 * 验证当前参数值是否是一个正确的邮箱
 * @param email 邮箱
 * @return boolean
 */
fun String.isEmail(email : String) = true

/**
 * 验证当前参数值是否全部由数字组成
 * @param str 源字符串
 * @return boolean
 */
fun String.isPureNum(str : String) : Boolean = false







