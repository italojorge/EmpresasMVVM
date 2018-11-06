package com.ioasys.empresasmvvm.model.api;

import com.ioasys.empresasmvvm.model.data.AuthRequest;
import com.ioasys.empresasmvvm.model.data.Enterprise;
import com.ioasys.empresasmvvm.model.data.User;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {
    @POST(PATH_SIGN_IN)
    Observable<Response<AuthRequest>> login(@Body User user);

    @GET(PATH_ENTERPRISES)
    Observable<List<Enterprise>> searchEnterprise(@Query(FIELD_NAME) String query, @HeaderMap HashMap<String, String> headers);


    String BASE_URL_PHOTO = "http://empresas.ioasys.com.br";

    String BASE_URL = "http://empresas.ioasys.com.br/api/v1/";

    String PATH_SIGN_IN = "users/auth/sign_in";

    String PATH_ENTERPRISES = "enterprises";

    String FIELD_NAME = "name";


}

