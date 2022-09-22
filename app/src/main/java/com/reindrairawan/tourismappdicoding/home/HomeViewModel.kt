package com.reindrairawan.tourismappdicoding.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()
}

