package com.ioasys.empresasmvvm.viewmodel;

import android.support.annotation.NonNull;

public class ViewState<T> {
    private T data;
    private Throwable error;
    private Status state;

    public enum Status {
        LOADING,
        SUCCESS,
        FAILURE
    }

    private ViewState(T data, Throwable error, Status state) {
        this.data = data;
        this.error = error;
        this.state = state;
    }

    @NonNull
    public static <U> ViewState success(U data){
        return new ViewState<>(data, null, Status.SUCCESS);
    }

    @NonNull
    public static ViewState error(Throwable error){
        return new ViewState<>("", error, Status.FAILURE);
    }

    @NonNull
    public static  ViewState loading(){
        return new ViewState<>("", null, Status.LOADING);
    }

    public Throwable getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Status getState() {
        return state;
    }
}
