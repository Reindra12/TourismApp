package com.reindrairawan.tourismappdicoding.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}