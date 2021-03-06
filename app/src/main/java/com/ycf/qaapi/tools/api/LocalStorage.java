package com.ycf.qaapi.tools.api;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.16   14:23
 * Des:          本地缓存存储的接口转换
 *
 * * */

import com.anupcowkur.reservoir.Reservoir;

import java.io.IOException;

public class LocalStorage {
    private static LocalStorage instance;
    private LocalStorage(){

    }
    public static LocalStorage init(){
        if (instance == null){
            instance = new LocalStorage();
        }
        return instance;
    }

    public static LocalStorage saveProperty(String key, Object value){
        try {
            Reservoir.put(key, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
