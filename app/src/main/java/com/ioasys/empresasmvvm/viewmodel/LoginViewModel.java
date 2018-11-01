package com.ioasys.empresasmvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;

import com.ioasys.empresasmvvm.model.LoginModel.User;

public class LoginViewModel extends ViewModel {

    //private final String TAG = LoginViewModel.class.toString();

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

    public void onLoginClicked() {

//        getBusy().setValue(0); //View.VISIBLE

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

        //Log.d(TAG, "Logado");
        if (user.isEmailValid() & user.isPasswordLengthGreaterThan5()) {
            viewState.postValue(new ViewState("", "", ViewState.State.SUCCESS));
        }
        // userMutableLiveData.setValue(user);
        //busy.setValue(8); //8 == View.GONE

    }

}
