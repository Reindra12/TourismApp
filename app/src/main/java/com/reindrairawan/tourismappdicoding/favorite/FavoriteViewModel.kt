package com.dicoding.tourismapp.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.TourismRepository
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

