package com.ioasys.empresasmvvm.view.Login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ioasys.empresasmvvm.R;
import com.ioasys.empresasmvvm.databinding.ActivityLoginBinding;
import com.ioasys.empresasmvvm.view.Seach.SearchActivity;
import com.ioasys.empresasmvvm.viewmodel.LoginViewModel;
import com.ioasys.empresasmvvm.viewmodel.ViewState;

import java.util.Objects;

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

        binding.getVm().getViewState().observe(this, new Observer<ViewState>() {
            @Override
            public void onChanged(@Nullable ViewState viewState) {
                binding.progressBar.setVisibility(View.GONE);
                binding.loginEmailsenhainvalidosTextView.setText("");
                switch (Objects.requireNonNull(viewState).getState()) {
                    case LOADING:
                        binding.progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case FAILURE:
                        binding.loginEmailsenhainvalidosTextView.setText(viewState.getError().getMessage());
                        break;
                }
            }
        });

    }
}
