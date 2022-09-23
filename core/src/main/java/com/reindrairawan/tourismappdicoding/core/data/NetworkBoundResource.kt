package com.reindrairawan.tourismappdicoding.core.data

import com.reindrairawan.tourismappdicoding.core.data.source.remote.network.ApiResponse
import com.reindrairawan.tourismappdicoding.core.utils.AppExecutors
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    private var result: Flow<com.reindrairawan.tourismappdicoding.core.data.Resource<ResultType>> = flow {
        emit(com.reindrairawan.tourismappdicoding.core.data.Resource.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(com.reindrairawan.tourismappdicoding.core.data.Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map {
                        com.reindrairawan.tourismappdicoding.core.data.Resource.Success(
                            it
                        )
                    })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map {
                        com.reindrairawan.tourismappdicoding.core.data.Resource.Success(
                            it
                        )
                    })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(
                        com.reindrairawan.tourismappdicoding.core.data.Resource.Error<ResultType>(
                            apiResponse.errorMessage
                        )
                    )
                }
            }
        } else {
            emitAll(loadFromDB().map {
                com.reindrairawan.tourismappdicoding.core.data.Resource.Success(
                    it
                )
            })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<com.reindrairawan.tourismappdicoding.core.data.Resource<ResultType>> = result


}