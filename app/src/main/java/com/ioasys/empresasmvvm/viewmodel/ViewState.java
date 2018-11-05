package com.ioasys.empresasmvvm.viewmodel;

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

    public ViewState<T> success(T data){
        return new ViewState<>(data, null, Status.SUCCESS);
    }

    public ViewState<T> error(Throwable error){
        return new ViewState<>(null, error, Status.FAILURE);
    }

    public ViewState<T> loading(T data){
        return new ViewState<>(null, null, Status.LOADING);
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
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

    public void setState(Status state) {
        this.state = state;
    }
}
