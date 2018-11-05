package com.ioasys.empresasmvvm.viewmodel;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;

public class BindingAdapters {
    @BindingAdapter("app:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }
}