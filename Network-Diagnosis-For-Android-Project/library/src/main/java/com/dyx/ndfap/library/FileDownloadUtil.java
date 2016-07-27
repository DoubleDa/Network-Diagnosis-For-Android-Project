package com.dyx.ndfap.library;

import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * project name：Network-Diagnosis-For-Android-Project
 * class describe：文件下载工具类
 * create person：dayongxin
 * create time：16/7/27 下午5:02
 * alter person：dayongxin
 * alter time：16/7/27 下午5:02
 * alter remark：
 */
public class FileDownloadUtil extends AsyncTask<String, String, String> {
    private String value;

    public String getValue() {
        return value;
    }

    //TODO http://www.open-open.com/code/view/1425653766415
    @Override
    protected String doInBackground(String... strings) {
        //下载文件
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int fileLength = connection.getContentLength();
            int totalLength = 0;
            int length = 0;
            is = connection.getInputStream();
            fos = new FileOutputStream(new File("", ""));
            byte[] buffer = new byte[1024 * 1024];
            while ((length = is.read(buffer)) > 0) {
                totalLength += length;
                String result = ((totalLength * 100) / fileLength) + "";
                publishProgress(result);
                fos.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(is);
            CloseUtil.closeQuietly(fos);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //预下载
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //结束下载
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        //下载进度更新
        values = values;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        //下载取消
    }
}
