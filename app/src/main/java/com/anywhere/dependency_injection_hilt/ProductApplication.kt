package com.anywhere.dependency_injection_hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Initializes Hilt and prepares it to inject dependencies entire Android app
//where all dependencies are created and managed.
@HiltAndroidApp
class ProductApplication : Application()