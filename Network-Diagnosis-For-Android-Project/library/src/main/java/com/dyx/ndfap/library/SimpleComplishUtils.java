package com.dyx.ndfap.library;

import android.content.Context;

import java.io.File;

/**
 * project name：Network-Diagnosis-For-Android-Project
 * class describe：简单实现工具类
 * create person：dayongxin
 * create time：16/7/27 下午4:11
 * alter person：dayongxin
 * alter time：16/7/27 下午4:11
 * alter remark：
 */
public class SimpleComplishUtils {
    /**
     * 判断流程：
     * 1、是否有网络；
     * 2、网络是否连通；
     * 3、连接指定服务器；
     * 4、下载文件；
     * 5、上传文件；
     */
    /**
     * 1、获取网络状态
     *
     * @param context
     * @return
     */
    public static String getNetworkState(Context context) {
        String result = "";
        if (NetUtil.isNetworkAvailable(context)) {
            result = context.getString(R.string.network_available);
        } else {
            result = context.getString(R.string.network_unavailable);
        }
        return result;
    }

    /**
     * 2、获取网络类型
     *
     * @param context
     * @return
     */
    public static String getNetworkType(Context context) {
        String result = "";
        if (NetUtil.isWifi(context)) {
            result = context.getString(R.string.network_type) + context.getString(R.string.network_type_wifi);
        } else if (NetUtil.getNetworkType(context).equals("2G") || NetUtil.getNetworkType(context).equals("3G") || NetUtil.getNetworkType(context).equals("4G")) {
            result = context.getString(R.string.network_type) + NetUtil.getNetworkType(context);
        }
        return result;
    }

    /**
     * 3、获取指定服务器状态
     *
     * @param context
     * @param serverUrl
     * @return
     */
    public static String getServerState(Context context, final String serverUrl) {
        ServerStateUtil util = new ServerStateUtil(context, serverUrl);
        util.getServerStateMsg();
        return util.getResult();
    }

    /**
     * 指定文件下载是否成功
     *
     * @param context
     * @param fileUrl
     * @return
     */
    public static boolean isFileDownloadSuccess(Context context, String fileUrl) {
        FileDownloadUtil util = (FileDownloadUtil) new FileDownloadUtil().execute(fileUrl);
        String progress = util.getValue();
        if (progress.equals("100")) {
            return true;
        }
        return false;
    }


    /**
     * 指定文件上传是否成功
     *
     * @param context
     * @param file
     * @return
     */
    public static boolean isFileUploadSuccess(Context context, File file) {
        //TODO
        return false;
    }
}
