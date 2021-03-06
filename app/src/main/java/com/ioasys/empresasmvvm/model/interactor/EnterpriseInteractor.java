package com.ioasys.empresasmvvm.model.interactor;

import com.ioasys.empresasmvvm.model.data.AuthRequest;
import com.ioasys.empresasmvvm.model.data.Enterprise;
import com.ioasys.empresasmvvm.model.data.HeaderApi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public interface EnterpriseInteractor {
    Observable<Response<AuthRequest>> login(String email, String password);

    Observable<List<Enterprise>> searchEnterprises(String query, HeaderApi headerApi);
}
