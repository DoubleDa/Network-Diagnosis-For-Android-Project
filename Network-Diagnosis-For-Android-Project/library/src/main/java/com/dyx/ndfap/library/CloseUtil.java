package com.dyx.ndfap.library;

import java.io.Closeable;
import java.io.IOException;

/**
 * project name：Network-Diagnosis-For-Android-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/27 下午6:22
 * alter person：dayongxin
 * alter time：16/7/27 下午6:22
 * alter remark：
 */
public class CloseUtil {
    /**
     * 关闭Closeable对象
     *
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
