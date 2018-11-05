package com.ioasys.empresasmvvm.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ioasys.empresasmvvm.model.LoginModel.User;
import com.ioasys.empresasmvvm.model.interactor.EnterpriseInteractorImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private EnterpriseInteractorImpl interactor = new EnterpriseInteractorImpl();
    private MutableLiveData<ViewState> viewState = new MutableLiveData<>();

    public MutableLiveData<String> passwordError = new MutableLiveData<>();
    public MutableLiveData<String> emailError = new MutableLiveData<>();

    public MutableLiveData<String> inputEmail = new MutableLiveData<>();
    public MutableLiveData<String> inputPassword = new MutableLiveData<>();

    private LoginSubscriber loginSubscriber;

    public MutableLiveData<ViewState> getViewState() {
        return viewState;
    }

    @SuppressLint("CheckResult")
    public void onLoginClicked() {

        User user = new User(inputEmail.getValue(), inputPassword.getValue());

        if (!user.isEmailValid()) {
            emailError.setValue("Digite um endereço de email válido");
        } else {
            emailError.setValue(null);
        }

        if (!user.isPasswordLengthGreaterThan5()) {
            passwordError.setValue("A senha deve conter no mínimo 6 dígitos");
        } else {
            passwordError.setValue(null);
        }

        if (user.isEmailValid() && user.isPasswordLengthGreaterThan5()) {

            viewState.postValue(ViewState.loading());

            loginSubscriber = interactor.login(user.getEmail(), user.getPassword())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new LoginSubscriber());
        }
    }

    private class LoginSubscriber extends DisposableObserver<Response> {
        @Override
        public void onNext(Response response) {

            if (response.isSuccessful()) {
                viewState.postValue(ViewState.success(""));
            } else {
                viewState.postValue(ViewState.error(new Exception("Usuário e/ou senha inválidos")));
            }
        }

        @Override
        public void onError(Throwable e) {
            viewState.postValue(ViewState.error(new Exception("Falha na Rede")));
        }

        @Override
        public void onComplete() {
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        loginSubscriber.dispose();
    }
}
