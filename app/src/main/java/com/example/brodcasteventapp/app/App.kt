package com.example.brodcasteventapp.app

import android.app.Application
import com.example.brodcasteventapp.data.MyShared

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyShared.init(this)
    }
}