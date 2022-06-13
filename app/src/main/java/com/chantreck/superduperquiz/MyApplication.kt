package com.chantreck.superduperquiz

import android.app.Application
import com.chantreck.superduperquiz.data.SharedPreferences

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferences.setup(applicationContext)
    }
}