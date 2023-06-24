package com.example.demoday.di

import org.koin.core.module.Module

val koinModules = listOf<Module>(
    repoModules,
    viewModules,
    networkModule
)