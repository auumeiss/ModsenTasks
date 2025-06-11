package com.modsen.tasksstepan

import android.app.Application
import com.modsen.tasksstepan.DI.tasksModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.koinConfiguration

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(tasksModule)
        }
    }
}