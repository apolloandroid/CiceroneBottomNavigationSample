package com.example.ciceronebottomnavigationsample.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ALocalRouter

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BLocalRouter

@Retention(AnnotationRetention.BINARY)
annotation class CLocalRouter

@Retention(AnnotationRetention.BINARY)
annotation class DLocalRouter