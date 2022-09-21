package com.dicoding.tourismapp.core.di

import android.content.Context

import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase

import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.utils.AppExecutors
import com.dicoding.tourismapp.core.utils.JsonHelper
import com.reindrairawan.tourismappdicoding.core.data.source.remote.network.ApiConfig
import com.reindrairawan.tourismappdicoding.core.data.source.remote.network.ApiService

object Injection {
    private fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}