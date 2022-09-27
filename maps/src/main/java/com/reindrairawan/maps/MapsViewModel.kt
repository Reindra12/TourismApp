package com.reindrairawan.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase):ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}