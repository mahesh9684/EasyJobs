package com.easyjobs.mahesh.easyjobs.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.easyjobs.mahesh.easyjobs.GetAllJobs;
import com.easyjobs.mahesh.easyjobs.JobsData;
import com.easyjobs.mahesh.easyjobs.R;
import com.easyjobs.mahesh.easyjobs.RetrofitService;
import com.easyjobs.mahesh.easyjobs.adapters.AllJobsShowAdapter;
import com.easyjobs.mahesh.easyjobs.interfaces.Api_Urls;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Api_Urls apis = null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        apis = RetrofitService.getRetrofitObject().create(Api_Urls.class);


        // Get all jobs

//        Call<List<GetAllJobs>> getAllJobs = apis.getAllJobs();
        Call<ResponseBody> getAllJobs = apis.getAllJobs();

        getAllJobs.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println("response " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                System.out.println("response failure body " + call.request());
            }
        });

//        getAllJobs.enqueue(new Callback<List<GetAllJobs>>() {
//            @Override
//            public void onResponse(Call<List<GetAllJobs>> call, Response<List<GetAllJobs>> response) {
//
//                List<GetAllJobs> getAllJobsList = response.body();
//                List<JobsData> jobsDataList = null;
//                for (GetAllJobs getAllJobs : getAllJobsList) {
//                    jobsDataList = getAllJobs.getData();
//                }
//                AllJobsShowAdapter adapter = new AllJobsShowAdapter(getApplicationContext(), jobsDataList);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<GetAllJobs>> call, Throwable t) {
//                System.out.println("GetAllData on failure ");
//            }
//        });
//        System.out.println("getAllJobs " + getAllJobs.);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked " + recyclerView.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
