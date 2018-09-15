package by.home.dartlen.dindindon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import by.home.dartlen.dindindon.timepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener,
        TimePickerDialog.OnMinuteSelectedListener, TimePickerDialog.OnHourSelectedListener{
    private lateinit var viewModel: AlarmClockViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, AlarmClockViewMOdelFactory())
                .get(AlarmClockViewModel::class.java)

        start.setOnClickListener {
            viewModel.start()
        }

        stop.setOnClickListener {
            viewModel.stop()
        }

        alarm.setOnClickListener {
            val dialog = TimePickerDialog.newInstance(this,this,
                    this, true)

            dialog.show(fragmentManager,"TAG")
        }
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

    }

    override fun onHourSelected(hour: Int) {
        Log.d("hour", hour.toString())
    }

    override fun onMinuteSelected(minute: Int) {
        Log.d("minutes", minute.toString())
    }

}
