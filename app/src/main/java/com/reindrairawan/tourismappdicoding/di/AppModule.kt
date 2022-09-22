package com.reindrairawan.tourismappdicoding.di

import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismInteractor
import com.reindrairawan.tourismappdicoding.core.domain.usecase.TourismUseCase
import com.reindrairawan.tourismappdicoding.detail.DetailTourismViewModel
import com.reindrairawan.tourismappdicoding.favorite.FavoriteViewModel
import com.reindrairawan.tourismappdicoding.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}