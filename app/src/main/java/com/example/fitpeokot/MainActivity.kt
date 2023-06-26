package com.example.fitpeokot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() , MyAdapter.CellClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        getAllData()
    }

    fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Model>>
        {
            override fun onResponse(
                call: Call<List<Model>>,
                response: Response<List<Model>>
            ) {
                if(response.isSuccessful)
                {
                    recyclerView = findViewById<RecyclerView>(R.id.customRecyclerView)
                        .apply{
                        myAdapter = MyAdapter(response.body()!!,this@MainActivity, cellClickListener = this@MainActivity)
                        layoutManager = manager
                        adapter = myAdapter

                        }

                    }
                }
            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
    override fun onCellClickListener(data: Model)
    {
        Log.d("data",data.thumbnailUrl)
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("id", data.id)
        intent.putExtra("albumId", data.albumId)
        intent.putExtra("thumbnailUrl", data.thumbnailUrl)
        intent.putExtra("title", data.title)
        intent.putExtra("url", data.url)
        startActivity(intent)
    }
}
