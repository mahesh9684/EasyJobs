package com.easyjobs.mahesh.easyjobs;

import com.easyjobs.mahesh.easyjobs.interfaces.Api_Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    static Retrofit retrofit = null;

    public static Retrofit getRetrofitObject() {
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
         interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


         retrofit = new Retrofit.Builder()
                 .baseUrl(Config.API_BASE_URL)
//                 .baseUrl("https://reqres.in")
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(client)
                 .build();



         return retrofit;
    }
}
