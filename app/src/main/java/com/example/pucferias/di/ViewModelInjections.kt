package com.example.pucferias.di

import com.example.pucferias.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

fun Module.viewModelInjections() {
    viewModel { MainViewModel(androidApplication()) }
}