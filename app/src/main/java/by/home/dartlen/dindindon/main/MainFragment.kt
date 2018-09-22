package by.home.dartlen.dindindon.main

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.AlarmManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import by.home.dartlen.dindindon.AlarmActivity
import by.home.dartlen.dindindon.AlarmReciver
import by.home.dartlen.dindindon.R
import by.home.dartlen.dindindon.timepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment(), TimePickerDialog.OnTimeSetListener,
        TimePickerDialog.OnMinuteSelectedListener, TimePickerDialog.OnHourSelectedListener,
        TimePickerDialog.OnOkListener, TimePickerDialog.OnClickedPendingAlarms, TimePickerDialog.OnClickedShareAlarm {

    private lateinit var viewModel: MainViewModel
    lateinit var dialog: TimePickerDialog
    var mHour: Int = 0
    var mMinute: Int = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        viewModel = ViewModelProviders.of(this, MainModelFactory())
                .get(MainViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            viewModel.start()
        }

        stop.setOnClickListener {
            viewModel.stop()
        }

        alarm.setOnClickListener {

            dialog = TimePickerDialog.newInstance(this, this,
                    this, this, this, this, true)
            dialog.show(activity!!.supportFragmentManager, "TAG")
        }

    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

    }

    override fun onHourSelected(hour: Int) {
        Log.d("hour", hour.toString())
        mHour = hour
    }

    override fun onMinuteSelected(minute: Int) {
        Log.d("minutes", minute.toString())
        mMinute = minute
    }

    override fun onOkListener() {
        val intent = Intent(activity, AlarmActivity::class.java.javaClass)
        val pendingIntent = PendingIntent.getActivity(activity, 1488,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val intentReciver = Intent(activity, AlarmReciver::class.java)
        //val pendingIntentReciver = PendingIntent.getBroadcast(this, 1488, intentReciver, PendingIntent.FLAG_UPDATE_CURRENT)
        val pendingIntentReciver = PendingIntent.getBroadcast(activity, 0,
                intentReciver, PendingIntent.FLAG_UPDATE_CURRENT)
        //val targetMS = System.currentTimeMillis()

        val alarmManager = activity!!.getSystemService(ALARM_SERVICE) as AlarmManager

        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, mHour)
        c.set(Calendar.MINUTE, mMinute)
        c.set(Calendar.SECOND, 0)
        /*var notificationScheduler = NotificationScheduler()
        notificationScheduler.setReminder(this@MainActivity, AlarmReciver::class.java, 2, 35)*/
        AlarmManagerCompat.setAlarmClock(alarmManager, c.timeInMillis, pendingIntent, pendingIntentReciver)
        /*AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, AlarmManager.RTC_WAKEUP,
                c.timeInMillis, pendingIntentReciver)*/

        dialog.dismiss()
    }

    override fun onPendingAlarms() {
        val navController = Navigation.findNavController(view!!)
        navController.navigate(R.id.pendingAlarms, null)
        dialog.dismiss()
    }

    override fun shareAlarm() {

    }
}