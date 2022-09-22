package com.reindrairawan.tourismappdicoding.core.data.source.remote.network

import com.reindrairawan.tourismappdicoding.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse //hapus Call, tambahkan suspend
}