package com.daniel.testglobal.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daniel.testglobal.R;
import com.daniel.testglobal.adapters.LaptopAdapter;
import com.daniel.testglobal.core.models.HomeObject;
import com.daniel.testglobal.core.retrofit.ServiceUtils;
import com.daniel.testglobal.core.retrofit.methods.ApiMethods;
import com.daniel.testglobal.core.views.CustomProgressDialog;
import com.daniel.testglobal.fragments.DetailFragment;
import com.daniel.testglobal.utils.SystemUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ApiMethods mAPIService;
    private CustomProgressDialog progress;

    private RecyclerView listHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initVariables();
        callService();
    }

    private void initVariables() {

        mAPIService = ServiceUtils.getAPIService();
        listHome = findViewById(R.id.listHome);

        listHome.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listHome.setLayoutManager(linearLayoutManager);

    }

    private void callService() {
        showProgress();
        mAPIService.getList().enqueue(new Callback<List<HomeObject>>() {
            @Override
            public void onResponse(@NonNull Call<List<HomeObject>> call, @NonNull Response<List<HomeObject>> response) {

                dismissProgress();
                if (response.body() != null &&
                        response.body().size() > 0)
                    initAdapter(response.body());
                else
                    Toast.makeText(HomeActivity.this, "Error al obtener listado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NonNull Call<List<HomeObject>> call, @NonNull Throwable t) {
                Log.v("HomeActivity", t.toString());
                dismissProgress();
                Toast.makeText(HomeActivity.this, "Error al obtener listado", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initAdapter(List<HomeObject> listLaptop) {

        LaptopAdapter adapter = new LaptopAdapter(this, listLaptop, listener);
        listHome.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private LaptopAdapter.OnItemClickListener listener = new LaptopAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(HomeObject data, View view) {
            if (data != null)
                initFragment(DetailFragment.newInstance(data));
        }
    };

    private void initFragment(Fragment fragment) {

        SystemUtils.replaceFragment(HomeActivity.this,
                R.id.container,
                "DetailFragment",
                true,
                null,
                fragment);

    }

    private void showProgress() {
        progress = new CustomProgressDialog(this);
        progress.show();
        progress.setCancelable(true);
        progress.setCanceledOnTouchOutside(false);
    }

    private void dismissProgress() {
        if (progress != null && progress.isShowing()) {
            progress.dismiss();
            progress.cancel();
        }
    }
}
