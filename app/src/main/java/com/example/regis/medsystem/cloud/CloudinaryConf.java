package com.example.regis.medsystem.cloud;

import com.cloudinary.android.MediaManager;
import com.example.regis.medsystem.MyApplication;

import java.util.HashMap;



public class CloudinaryConf {
     static HashMap getConfig(){
        HashMap config=new HashMap();
        config.put("cloud_name","rex7");
        config.put("api_key","249961355415313");
        config.put("api_secret","r5hRpHt8olqFtYby8kZQ5Mo2RX4");
         config.put("use_filename","true");
         config.put("unique_filename ","false");
         MediaManager.init(MyApplication.getApplicationConext(),config);


        return  config;
    }
}
