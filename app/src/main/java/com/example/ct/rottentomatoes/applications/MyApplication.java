package com.example.ct.rottentomatoes.applications;

import android.app.Application;

import com.example.ct.rottentomatoes.RottenService;
import com.orhanobut.wasp.Wasp;
import com.orhanobut.wasp.parsers.GsonParser;
import com.orhanobut.wasp.utils.AuthToken;
import com.orhanobut.wasp.utils.LogLevel;
import com.orhanobut.wasp.utils.RequestInterceptor;
import com.orhanobut.wasp.utils.SimpleInterceptor;
import com.orhanobut.wasp.utils.WaspRetryPolicy;

import java.net.CookiePolicy;
import java.util.Map;


public class MyApplication extends Application {
    private static RottenService service;
    @Override
    public void onCreate() {
        super.onCreate();
        RequestInterceptor interceptor = new SimpleInterceptor() {
            @Override
            public void onQueryParamsAdded(Map<String, Object> stringObjectMap) {
                stringObjectMap.put("apikey","n594qzwyec5cdgr3tdrpfee3");
            }
        };
        service = new Wasp.Builder(this)
                .setEndpoint("http://api.rottentomatoes.com/api/public/v1.0")
                .setLogLevel(LogLevel.FULL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(RottenService.class);
    }

    public static RottenService getService() {
        return service;
    }
}
