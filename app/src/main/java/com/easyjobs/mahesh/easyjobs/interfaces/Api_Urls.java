package com.easyjobs.mahesh.easyjobs.interfaces;

import com.easyjobs.mahesh.easyjobs.GetAllJobs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Urls {

    @GET("/api/jobs")
//    @GET("/api/unknown")
    Call<List<GetAllJobs>> getAllJobs();

    @GET("/api/job/")
    Call<List<GetAllJobs>> getJob(@Body String job_id);

    @GET("/api/job?")
    Call<List<GetAllJobs>> getJobByName(@Query("page") String name);

}
