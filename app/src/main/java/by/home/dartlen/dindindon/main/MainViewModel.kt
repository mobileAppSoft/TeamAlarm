package by.home.dartlen.dindindon.main

import androidx.lifecycle.ViewModel
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import by.home.dartlen.dindindon.worker.AlarmClock
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    lateinit var alarmClock: PeriodicWorkRequest

    init {
    }

    fun start() {
        alarmClock = PeriodicWorkRequest.Builder(AlarmClock::class.java, 24, TimeUnit.HOURS)
                .addTag("alarm")
                .build()

        WorkManager.getInstance().enqueue(alarmClock)
    }

    fun stop() {
        WorkManager.getInstance().cancelWorkById(alarmClock.id)
    }


}