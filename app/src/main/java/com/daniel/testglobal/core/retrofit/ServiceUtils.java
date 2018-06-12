package com.daniel.testglobal.core.retrofit;

import com.daniel.testglobal.core.retrofit.methods.ApiMethods;

public class ServiceUtils {

    private static String baseURL = "http://private-f0eea-mobilegllatam.apiary-mock.com";

    private ServiceUtils() {
    }

    public static ApiMethods getAPIService() {

        return ServiceCore.getClient(baseURL).create(ApiMethods.class);

    }

}
