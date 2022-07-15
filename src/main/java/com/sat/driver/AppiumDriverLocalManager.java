package com.sat.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.URL;

import com.sat.config.Constants;

public class AppiumDriverLocalManager {
    
    private static AppiumDriverLocalService service;

    public static void run() { 
        // if (Constants.TARGET.toUpperCase().equals("LOCAL")){
        //     start();
        // }
        start();
    }

    public static void start() {
        try {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        } catch (Exception e) {
            System.out.println("Failed to start local appium!");
            System.out.println(e.getMessage());
            System.out.println("Appium is not setup correctly on this machine, more info in log above");
        }
        
    }

    public static void stop() {
        if (service != null) {
            service.stop();
        }
    }

    public static URL getServiceUrl() {
        return service.getUrl();
    }

}