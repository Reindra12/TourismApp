package com.reindrairawan.tourismappdicoding

import android.app.Application
import com.reindrairawan.tourismappdicoding.core.di.databaseModule
import com.reindrairawan.tourismappdicoding.core.di.networkModule
import com.reindrairawan.tourismappdicoding.core.di.repositoryModule
import com.reindrairawan.tourismappdicoding.di.useCaseModule
import com.reindrairawan.tourismappdicoding.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}
