package by.home.dartlen.dindindon.pendingalarms

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import by.home.dartlen.dindindon.R

class PendingAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_acivity)

        supportFragmentManager.beginTransaction().add(R.id.ok, PendingAlarmsFragmentJava()).commit()

    }

}
