package com.ioasys.empresasmvvm.model.interactor;

import com.ioasys.empresasmvvm.model.data.Enterprise;
import com.ioasys.empresasmvvm.model.data.HeaderApi;
import com.ioasys.empresasmvvm.model.remote.RemoteDataStoreImpl;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public class EnterpriseInteractorImpl implements EnterpriseInteractor{
    private RemoteDataStoreImpl remoteDataStore= new RemoteDataStoreImpl();

    @Override
    public Observable<Response> login(String email, String password) {
        return remoteDataStore.login(email,password);
    }

    @Override
    public Observable<List<Enterprise>> searchEnterprises(String query, HeaderApi headerApi) {
        return remoteDataStore.searchEnterprises(query,headerApi);
    }
}
