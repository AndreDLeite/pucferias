package com.example.pucferias.di

import org.koin.dsl.module

class AppModules {

    fun createModules() = module {
        viewModelInjections()
    }

}