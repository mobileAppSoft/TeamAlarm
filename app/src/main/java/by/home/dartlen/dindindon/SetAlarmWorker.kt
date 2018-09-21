package by.home.dartlen.dindindon

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.util.Log
import androidx.core.app.AlarmManagerCompat
import androidx.work.Worker
import by.home.dartlen.dindindon.Constants.TIME_ALARM
import java.util.*

class SetAlarmWorker : Worker() {

    override fun doWork(): Result {
        val firstValue = inputData.getLong(TIME_ALARM, 1)

        val intent = Intent(applicationContext, AlarmActivity::class.java.javaClass)
        val pendingIntent = PendingIntent.getActivity(applicationContext, 1488, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val intentReciver = Intent(applicationContext, AlarmReciver::class.java)
        val pendingIntentReciver = PendingIntent.getBroadcast(applicationContext, 0, intentReciver, PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = applicationContext.getSystemService(ALARM_SERVICE) as AlarmManager

        AlarmManagerCompat.setAlarmClock(alarmManager, firstValue, pendingIntent, pendingIntentReciver)

        return Result.SUCCESS
    }
}