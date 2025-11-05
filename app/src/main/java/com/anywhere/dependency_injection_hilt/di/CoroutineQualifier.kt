package com.anywhere.dependency_injection_hilt.di

import javax.inject.Qualifier

@Qualifier // it tells how long the annotation should exist
@Retention(AnnotationRetention.RUNTIME) //annotation will be available at runtime
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainDispatcher


