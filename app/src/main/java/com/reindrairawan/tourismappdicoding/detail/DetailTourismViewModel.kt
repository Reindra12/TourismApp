package com.reindrairawan.tourismappdicoding.detail

import androidx.lifecycle.ViewModel
import com.reindrairawan.tourismappdicoding.core.domain.model.Tourism
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

