package com.etsy.automation.session;

import java.util.HashMap;


public class DataStore {

    private static HashMap data = new HashMap();
   // private static HashMap data1 = new HashMap();

    //session object for scenario which keeps data with key value pair
    public static void setDataKey(String key, String value) {
        data.put(key, value);
    }

    public static String getDataKey(String key) {
        return data.get(key).toString();
    }
}

