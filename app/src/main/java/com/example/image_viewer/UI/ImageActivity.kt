package com.example.image_viewer.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.image_viewer.API.ApiClient
import com.example.image_viewer.API.ApiInterface
import com.example.image_viewer.Models.Image
import com.example.image_viewer.Models.ImageRVAdapter
import com.example.image_viewer.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageActivity : AppCompatActivity() {
    lateinit var rvImages:RecyclerView
    lateinit var tvUser:TextView
    lateinit var tvCaption:TextView
    lateinit var imPerson:ImageView
    lateinit var tvImageId:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        castViews()
        displayImages()
    }
    fun castViews(){

    }
    fun displayImages(){
        var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.viewImages()
        request.enqueue(object: Callback<List<Image>> {
            override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>) {
                if(response.isSuccessful){
                    var photos=response.body()
                    Toast.makeText(baseContext, "${photos!!.size} photos", Toast.LENGTH_SHORT).show()

                    rvImages=findViewById(R.id.rvImages)
                    var imageAdapter = ImageRVAdapter(photos,baseContext)
                    rvImages.layoutManager= LinearLayoutManager(baseContext)
                    rvImages.adapter= imageAdapter
                }
            }

            override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                Toast.makeText(baseContext,"error", Toast.LENGTH_LONG).show()
            }


        })
    }
}