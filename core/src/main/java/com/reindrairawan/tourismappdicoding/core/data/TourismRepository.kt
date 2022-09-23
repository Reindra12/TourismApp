package com.reindrairawan.tourismappdicoding.core.data

import com.reindrairawan.tourismappdicoding.core.data.source.local.LocalDataSource
import com.reindrairawan.tourismappdicoding.core.data.source.remote.RemoteDataSource
import com.reindrairawan.tourismappdicoding.core.data.source.remote.network.ApiResponse
import com.reindrairawan.tourismappdicoding.core.data.source.remote.response.TourismResponse
import com.reindrairawan.tourismappdicoding.core.utils.AppExecutors
import com.reindrairawan.tourismappdicoding.core.utils.DataMapper
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism
import com.reindrairawan.tourismappdicoding.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class TourismRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: com.reindrairawan.tourismappdicoding.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

   override fun getAllTourism(): Flow<com.reindrairawan.tourismappdicoding.core.data.Resource<List<Tourism>>> =
        object : com.reindrairawan.tourismappdicoding.core.data.NetworkBoundResource<List<Tourism>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()


    override fun getFavoriteTourism(): Flow<List<Tourism>> {
       return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

   override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

