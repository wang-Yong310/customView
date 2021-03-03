package com.example.customview.MyUtils

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context


/**
 * @author wangyong
 * @date 2/3/21 9:06 PM
 */
object MyUtils {
    /**
     * 根据Pid获取当前进程的名字，一般就是当前app的包名
     *
     * @param context 上下文
     * @param pid 进程的id
     * @return 返回进程的名字
     */
     fun getAppName(context: Context, pid: Int): String? {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val list: List<*> = activityManager.runningAppProcesses
        val i = list.iterator()
        while (i.hasNext()) {
            val info = i.next() as RunningAppProcessInfo
            try {
                if (info.pid == pid) {
                    // 根据进程的信息获取当前进程的名字
                    return info.processName
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        // 没有匹配的项，返回为null
        return null
    }
}