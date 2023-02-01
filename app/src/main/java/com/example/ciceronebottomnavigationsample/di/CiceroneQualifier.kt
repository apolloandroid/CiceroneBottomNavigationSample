package com.example.ciceronebottomnavigationsample.di

import javax.inject.Qualifier

/**
 * Each [Qualifier] corresponds to separate navigation tab
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ACicerone

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BCicerone

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CCicerone

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DCicerone
