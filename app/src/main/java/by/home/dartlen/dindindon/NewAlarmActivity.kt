package by.home.dartlen.dindindon

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import by.home.dartlen.dindindon.timepicker.time.TimePickerDialog

class NewAlarmActivity : AppCompatActivity(), TimePickerDialog.OnMinuteSelectedListener, TimePickerDialog.OnClickedPendingAlarms, TimePickerDialog.OnTimeSetListener, TimePickerDialog.OnHourSelectedListener, TimePickerDialog.OnClickedShareAlarm, TimePickerDialog.OnOkListener {
    override fun onOkListener() {

    }

    override fun shareAlarm() {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }

    override fun onHourSelected(hour: Int) {

    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

    }

    override fun onPendingAlarms() {

    }

    override fun onMinuteSelected(minute: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.alarm_activity)

        val dialog = TimePickerDialog.newInstance(this, this,
                this, this, this, this, true)

        supportFragmentManager.beginTransaction().add(dialog, "dialog").commit()
    }


}
