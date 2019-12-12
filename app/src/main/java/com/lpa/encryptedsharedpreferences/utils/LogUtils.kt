package com.lpa.encryptedsharedpreferences.utils

import android.util.Log
import com.lpa.encryptedsharedpreferences.BuildConfig

fun Any.log(msg: String, tag: String = this.javaClass.simpleName) {
    LogUtils.log(LogUtils.Type.I, tag, msg)
}


object LogUtils {
    enum class Type {
        V, D, I, W, E
    }

    fun log(type: Type, tag: String? = "", message: String) {
        //TAG ONLY ON DEBUG Mode
        if (BuildConfig.DEBUG) {
            when (type) {
                LogUtils.Type.V -> {
                    try {
                        Log.v(tag, message)
                    } catch (e: Exception) {
                        println("$tag:$message")
                    }
                }
                LogUtils.Type.I -> {
                    try {
                        Log.i(tag, message)
                    } catch (e: Exception) {
                        println("$tag:$message")

                    }
                }
                LogUtils.Type.W -> Log.w(tag, message)
                LogUtils.Type.E -> Log.e(tag, message)
                else -> {
                    Log.d(tag, message)
                }
            }
        }
    }
}
