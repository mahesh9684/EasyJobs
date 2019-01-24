package com.easyjobs.mahesh.easyjobs.interfaces;

import com.easyjobs.mahesh.easyjobs.GetAllJobs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.ResponseCache;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api_Urls {

    //    @GET("/api/jobs")
    @GET("EasyJobServices/webresources/easyjob/getjobs")
    Call<ResponseBody> getAllJobs();

    @POST("EasyJobServices/webresources/easyjob/addjob")
    Call<ResponseBody> addJobs(@Body String data);

    @GET("/api/job/")
    Call<List<GetAllJobs>> getJob(@Body String job_id);

    @GET("/api/job?")
    Call<List<GetAllJobs>> getJobByName(@Query("page") String name);

}
