package com.ioasys.empresasmvvm.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.util.Log;

import com.ioasys.empresasmvvm.model.LoginModel.User;
import com.ioasys.empresasmvvm.model.data.AuthRequest;
import com.ioasys.empresasmvvm.model.remote.RemoteDataStore;
import com.ioasys.empresasmvvm.model.remote.RemoteDataStoreImpl;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private final String TAG = LoginViewModel.class.toString();
    private RemoteDataStore interactor = new RemoteDataStoreImpl();

    public MutableLiveData<ViewState> viewState = new MutableLiveData<>();

    public MutableLiveData<String> passwordError = new MutableLiveData<>();
    public MutableLiveData<String> emailError = new MutableLiveData<>();

    public MutableLiveData<String> inputEmail = new MutableLiveData<>();
    public MutableLiveData<String> inputPassword = new MutableLiveData<>();
    //public MutableLiveData<Integer> busy;

    public LoginViewModel() {
    }

    /*
    public MutableLiveData<Integer> getBusy() {

        if (busy == null) {
            busy = new MutableLiveData<>();
            busy.setValue(8);
        }

        return busy;
    }
    */

    @BindingAdapter("app:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    @SuppressLint("CheckResult")
    public void onLoginClicked() {

 /*       User user = new User(inputEmail.getValue(), inputPassword.getValue());

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

        //Log.d(TAG, "Logado");
        if (user.isEmailValid() & user.isPasswordLengthGreaterThan5()) {
 */
        interactor.login("testeapple@ioasys.com.br", "12341234")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<AuthRequest>>() {
                    @Override
                    public void onNext(Response<AuthRequest> authRequestResponse) {

                        if (authRequestResponse.isSuccessful()) {
                            Log.d(TAG, "deu bom: "+authRequestResponse.body().getSuccess().toString());
                        }else {
                            Log.d(TAG, "Deu ruim");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Deu erro");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //viewState.postValue(new ViewState("", "", ViewState.State.SUCCESS));
    }

    //}

}
