package com.example.image_viewer.API

import com.example.image_viewer.Models.Image
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/photos")
   fun viewImages(): Call<List<Image>>

}