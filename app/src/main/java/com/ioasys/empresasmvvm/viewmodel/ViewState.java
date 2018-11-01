package com.ioasys.empresasmvvm.viewmodel;

public class ViewState<T> {
    public T data;
    public String error;
    public State state;

    ViewState(T data, String error, State state) {
        this.data = data;
        this.error = error;
        this.state = state;
    }

    public enum State {
        LOADING,
        SUCCESS,
        FAILURE
    }
}
