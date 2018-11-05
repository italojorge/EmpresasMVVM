package com.ioasys.empresasmvvm.model.remote;

import com.ioasys.empresasmvvm.model.api.WebService;

import static com.ioasys.empresasmvvm.model.api.WebService.BASE_URL;

public class ApiUtils {

    private ApiUtils() {}

    public static WebService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(WebService.class);
    }
}
