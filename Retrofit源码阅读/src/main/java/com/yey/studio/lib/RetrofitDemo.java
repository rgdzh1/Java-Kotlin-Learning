package com.yey.studio.lib;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;



public class RetrofitDemo {
    interface GitHubService {
        @GET("users/{user}/repos")
        Call<Object> listRepos(@Path("user") String user);
    }
    public static void main(String[] args) {
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .client(new OkHttpClient()
                                .newBuilder()
                                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                                    @Override
                                    public void log(String message) {
                                        System.out.println("Retrofiit源码阅读: " + message);
                                    }
                                })
                                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                                .build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();


        GitHubService service = retrofit.create(GitHubService.class);
        Call<Object> call = service.listRepos("octocat");
//        try {
//            Response<Object> execute = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }
}
