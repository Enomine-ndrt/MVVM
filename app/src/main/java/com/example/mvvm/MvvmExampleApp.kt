package com.example.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp//crear entrada de App tambien se tiene que indicar en el manifest con campo name
class MvvmExampleApp:Application()