package com.example.demoday.di

import com.example.demoday.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}

