package com.ioasys.empresasmvvm.view.Login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ioasys.empresasmvvm.R;
import com.ioasys.empresasmvvm.databinding.ActivityLoginBinding;
import com.ioasys.empresasmvvm.view.Seach.SearchActivity;
import com.ioasys.empresasmvvm.viewmodel.LoginViewModel;
import com.ioasys.empresasmvvm.viewmodel.ViewState;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setVm(loginViewModel);
        binding.setLifecycleOwner(this);


        binding.getVm().viewState.observe(this, new Observer<ViewState>() {
            @Override
            public void onChanged(@Nullable ViewState viewState) {
                assert viewState != null;
                switch (viewState.state) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent);
                        break;
                    case FAILURE:
                        break;
                }
            }
        });

    }
}
