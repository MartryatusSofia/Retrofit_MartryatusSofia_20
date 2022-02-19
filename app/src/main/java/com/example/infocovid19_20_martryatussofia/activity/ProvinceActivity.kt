package com.example.infocovid19_20_martryatussofia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid19_20_martryatussofia.R
import com.example.infocovid19_20_martryatussofia.adapter.ProvinceAdapter
import com.example.infocovid19_20_martryatussofia.api.RetrofitClient
import com.example.infocovid19_20_martryatussofia.model.IndonesiaResponse
import com.example.infocovid19_20_martryatussofia.model.Province
import com.example.infocovid19_20_martryatussofia.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }

    private fun showProvince() {
        val rvProvince : RecyclerView = findViewById(R.id.rvProvince)

        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvince()
            .enqueue(object : Callback<ArrayList<ProvinceResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<ProvinceResponse>>,
                    response: Response<ArrayList<ProvinceResponse>>
                ) {
                    val list = response.body()
                    val adapter = list?.let { ProvinceAdapter(it) }
                    rvProvince.adapter = adapter
                }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}