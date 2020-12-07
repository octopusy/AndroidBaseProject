package com.richard.androidbaseproject.utils

import java.lang.reflect.ParameterizedType

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/7 0007 08:43
 * @email：zhangyang5547662@126.com
 */
class TUtil {

    companion object {
        fun <T> getT(o: Any, i: Int): T? {
            try {
                return ((o.javaClass
                    .genericSuperclass as ParameterizedType).actualTypeArguments[i] as Class<T>)
                    .newInstance()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: ClassCastException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return null
        }

        fun forName(className: String?): Class<*>? {
            try {
                return Class.forName(className)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
            return null
        }
    }
}