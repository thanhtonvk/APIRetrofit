package com.tondz.apiretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    @GET("students")
    Call<List<Student>> getStudentList();
    @GET("students/{studentID}")
    Call<Student> getStudentById(@Path("studentID") String studentID);
    @POST("students")
    Call<String> addStudent(@Body Student student);
    @PATCH("students/{studentID}")
    Call<String> updateStudent(@Path("studentID") String id,@Body Student student);
    @DELETE("students/{studentID}")
    Call<String> deleteStudent(@Path("studentID") String id);




    @GET("Quang040422")
    Call<String>getQuang();
    Gson gson = new GsonBuilder().setLenient().setDateFormat("dd/MM/yyyy").create();
    APIService apiService = new Retrofit.Builder().baseUrl("https://nodeshop123.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);
    @GET("forecast/daily")
    Call<OpenWheather> getWheather(@Query("q") String q,@Query("mode") String mode,@Query("APPID") String id);
    @GET("api/taikhoans/{taikhoan}")
    Call<ThongTinTaiKhoan> GetThongTinTaiKhoan(@Path("taikhoan") String tentk);
    @GET("api/taikhoans/get-tai-khoan")
    Call<ArrayList<TaiKhoan>> GetAllTaiKhoan();

}
