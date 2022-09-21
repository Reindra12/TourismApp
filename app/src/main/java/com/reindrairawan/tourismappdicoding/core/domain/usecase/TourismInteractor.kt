package com.reindrairawan.tourismappdicoding.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.data.TourismRepository
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism

class TourismInteractor(private val tourismRepository: TourismRepository) : TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}