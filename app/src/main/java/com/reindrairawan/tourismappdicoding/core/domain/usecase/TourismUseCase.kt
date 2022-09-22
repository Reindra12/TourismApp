package com.reindrairawan.tourismappdicoding.core.domain.usecase

import com.reindrairawan.tourismappdicoding.core.data.Resource
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}