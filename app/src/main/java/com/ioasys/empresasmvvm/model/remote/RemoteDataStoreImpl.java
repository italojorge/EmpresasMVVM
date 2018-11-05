package com.ioasys.empresasmvvm.model.remote;

import com.ioasys.empresasmvvm.model.api.WebService;
import com.ioasys.empresasmvvm.model.data.AuthRequest;
import com.ioasys.empresasmvvm.model.data.Enterprise;
import com.ioasys.empresasmvvm.model.data.HeaderApi;
import com.ioasys.empresasmvvm.model.data.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public class RemoteDataStoreImpl implements RemoteDataStore{
    private WebService webService =  ApiUtils.getAPIService();

    @Override
    public Observable<List<Enterprise>> searchEnterprises(String query, HeaderApi headerApi) {
        return null;
    }

    @Override
    public Observable<Response<AuthRequest>> login(String email, String senha) {
            return webService.login( email,senha );
    }
/*
    @Override
    public Observable<List<Enterprise>> searchEnterprises(String query, HeaderApi headerApi) {

            return webService.searchEnterprise(query,
                    )
            )
    }
    */
}
