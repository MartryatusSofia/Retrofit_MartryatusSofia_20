package com.example.infocovid19_20_martryatussofia.api

import com.example.infocovid19_20_martryatussofia.model.IndonesiaResponse
import com.example.infocovid19_20_martryatussofia.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api{
    @GET ("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET ("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}

