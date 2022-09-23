package com.reindrairawan.tourismappdicoding.core.domain.repository

import com.reindrairawan.tourismappdicoding.core.data.Resource
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<com.reindrairawan.tourismappdicoding.core.data.Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}