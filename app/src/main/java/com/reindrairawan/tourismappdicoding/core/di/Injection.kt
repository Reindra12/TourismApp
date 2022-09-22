package com.reindrairawan.tourismappdicoding.core.di

import android.content.Context
import com.reindrairawan.tourismappdicoding.core.data.TourismRepository
import com.reindrairawan.tourismappdicoding.core.data.source.local.LocalDataSource
import com.reindrairawan.tourismappdicoding.core.data.source.local.room.TourismDatabase
import com.reindrairawan.tourismappdicoding.core.data.source.remote.RemoteDataSource
import com.reindrairawan.tourismappdicoding.core.utils.AppExecutors
import com.reindrairawan.tourismappdicoding.core.data.source.remote.network.ApiConfig
import com.reindrairawan.tourismappdicoding.core.domain.repository.ITourismRepository
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismInteractor
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase

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