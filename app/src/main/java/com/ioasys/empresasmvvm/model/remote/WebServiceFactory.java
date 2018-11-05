package com.ioasys.empresasmvvm.model.remote;

import com.ioasys.empresasmvvm.model.api.WebService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ioasys.empresasmvvm.model.api.WebService.BASE_URL;

public class WebServiceFactory {

    public static WebService getAPIService() {
        return WebServiceFactory.getClient(BASE_URL);
    }

    private static WebService retrofit = null;

    private static WebService getClient(String url) {
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(WebService.class);
        }
        return retrofit;
    }

}
