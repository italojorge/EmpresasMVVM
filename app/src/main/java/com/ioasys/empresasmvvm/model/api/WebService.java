package com.ioasys.empresasmvvm.model.api;

import com.ioasys.empresasmvvm.model.data.AuthRequest;
import com.ioasys.empresasmvvm.model.data.Enterprise;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {
    @POST(PATH_SIGN_IN)
    @FormUrlEncoded
    Observable<Response<AuthRequest>> login(@Field("email") String email,
                                            @Field("password") String password);

    @GET(PATH_ENTERPRISES)
    Observable<List<Enterprise>> searchEnterprise(@Query(FIELD_NAME) String query, @HeaderMap HashMap<String, String> headers);


    public static final String BASE_URL_PHOTO = "http://empresas.ioasys.com.br";

    public static final String BASE_URL = "http://empresas.ioasys.com.br/api/v1/";

    public static final String PATH_SIGN_IN = "users/auth/sign_in";

    public static final String PATH_ENTERPRISES = "enterprises";

    public static final String FIELD_NAME = "name";


}

