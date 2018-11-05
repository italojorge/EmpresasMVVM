package com.ioasys.empresasmvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class SearchViewModel extends ViewModel {
    //MutableLiveData<>

    public void searchEnterprises(String search){
        Log.d(SearchViewModel.class.toString(),"Pesquisa no servidor");
    }
}
