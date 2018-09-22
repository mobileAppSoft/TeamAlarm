package by.home.dartlen.dindindon

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class AlarmReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("RECIVER", "WORK")
        var notificationScheduler = NotificationScheduler()
        notificationScheduler.showNotification(context!!, MainActivity::class.java, "TeamAlarm", Date().time.toString())

        Intent(context, AlarmActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //putExtra(ALARM_ID, id)
            context.startActivity(this)
        }
    }
}