package com.ioasys.empresasmvvm.view.Seach;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;

import com.ioasys.empresasmvvm.R;
import com.ioasys.empresasmvvm.databinding.ActivitySearchBinding;
import com.ioasys.empresasmvvm.viewmodel.SearchViewModel;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        binding.setVm(searchViewModel);
        binding.setLifecycleOwner(this);

        setSupportActionBar(binding.pesquisarToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_seachView).getActionView();
        searchView.setQueryHint("Pesquisar");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null)
                    searchViewModel.searchEnterprises(query);
                //mRecyclerView.setVisibility(View.VISIBLE);
                //mPesquiseAcima.setVisibility(View.INVISIBLE);
                //verificaEmpresaNoServidor(mClient, mUid, mAccess_token, query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }
}
