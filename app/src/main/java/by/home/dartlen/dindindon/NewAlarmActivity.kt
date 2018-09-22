package by.home.dartlen.dindindon

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.AlarmManagerCompat
import androidx.navigation.Navigation
import by.home.dartlen.dindindon.Constants.PREFS_FILENAME
import by.home.dartlen.dindindon.Constants.TIME_ALARM
import by.home.dartlen.dindindon.timepicker.time.TimePickerDialog
import java.util.*
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController


class NewAlarmActivity : AppCompatActivity(), TimePickerDialog.OnMinuteSelectedListener, TimePickerDialog.OnClickedPendingAlarms, TimePickerDialog.OnTimeSetListener, TimePickerDialog.OnHourSelectedListener, TimePickerDialog.OnClickedShareAlarm, TimePickerDialog.OnOkListener {

    lateinit var dialog: TimePickerDialog
    var mHour: Int = 0
    var mMinute: Int = 0
    lateinit var navController:NavController

    override fun onOkListener() {
        val intent = Intent(this, AlarmActivity::class.java.javaClass)
        val pendingIntent = PendingIntent.getActivity(this, 1488,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val intentReciver = Intent(this, AlarmReciver::class.java)
        val pendingIntentReciver = PendingIntent.getBroadcast(this, 0,
                intentReciver, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, mHour)
        c.set(Calendar.MINUTE, mMinute)
        c.set(Calendar.SECOND, 0)
        AlarmManagerCompat.setAlarmClock(alarmManager, c.timeInMillis, pendingIntent, pendingIntentReciver)
        dialog.dismiss()
    }

    override fun shareAlarm() {
        val prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, mHour)
        c.set(Calendar.MINUTE, mMinute)
        c.set(Calendar.SECOND, 0)

        val editor = prefs!!.edit()
        editor.putLong(TIME_ALARM, c.timeInMillis)
        editor.apply()


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onHourSelected(hour: Int) {
        mHour = hour
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

    }

    override fun onPendingAlarms() {

        navController.navigate(R.id.pendingAlarms, null)
    }

    override fun onMinuteSelected(minute: Int) {
        mMinute = minute
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.alarm_activity)

        dialog = TimePickerDialog.newInstance(this, this,
                this, this, this, this, true)
        supportFragmentManager.beginTransaction().add(dialog, "dialog").commit()
    }


}
