package com.ycf.qaapi.tools;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.10   11:55
 * Des:
 *
 * * */

import android.util.Log;

import com.ycf.qaapi.BuildConfig;

public class LogUtil {
    public static boolean LOG_FLAG = BuildConfig.DEBUG;  //是否打印日志开关（gradle配置中动态注入的。）
    public static void i(String tag, String content) {
        if (LOG_FLAG)
            Log.i(tag, content);
    }
    public static void d(String tag, String content) {
        if (LOG_FLAG)
            Log.d(tag, content + getCurrentStackTraceInfo());
    }

    public static void v(String tag, String content) {
        if (LOG_FLAG)
            Log.v(tag, content);
    }

    public static void e(String tag, String content) {
        if (LOG_FLAG)
            Log.e(tag, content + getCurrentStackTraceInfo());
    }

    public static void e(String tag, String content, Exception e) {
        if (LOG_FLAG)
            Log.e(tag, content + getCurrentStackTraceInfo(), e);
    }

    public static void w(String tag, String content) {
        if (LOG_FLAG)
            Log.w(tag, content + getCurrentStackTraceInfo());
    }

    private static String getCurrentStackTraceInfo(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String info = "";
        int traceCount  = stackTraceElements.length;
        if (traceCount > 0){
            StackTraceElement lastTrace = stackTraceElements[traceCount-1];
            info = "\nat " + lastTrace.getClassName() + "." + lastTrace.getMethodName() + "("+lastTrace.getFileName()+":"
                    +lastTrace.getLineNumber()+")";
        }
        return info;
    }

    /**
     * 获取指定堆栈的堆栈信息
     * @param stackTraceElements
     * @return
     */
    public static String getAllInfoFromStackTrace( StackTraceElement[] stackTraceElements){
        StringBuilder infoBuilder = new StringBuilder("");
        int traceCount  = stackTraceElements.length;
        if (traceCount > 0){
            infoBuilder.append("\nHere is all stackTrace Info:\n");
        }
        for (StackTraceElement tmpTrace : stackTraceElements){
            infoBuilder.append(
                    "\nat " + tmpTrace.getClassName() + "." + tmpTrace.getMethodName() + "("+tmpTrace.getFileName()+":"
                            +tmpTrace.getLineNumber()+")");
        }
        return infoBuilder.toString();
    }

    private static String getCurrentClassName(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String currentClassName = "";
        if (stackTraceElements.length > 0){
            currentClassName = stackTraceElements[stackTraceElements.length-1]
                    .getClassName();
//                    .substring(stackTraceElements[stackTraceElements.length-1]
//                            .getClassName().indexOf(".")+1);
        }
        return currentClassName;
    }
}
