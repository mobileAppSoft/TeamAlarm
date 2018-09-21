package by.home.dartlen.dindindon.worker

import android.media.MediaPlayer
import androidx.work.Worker
import by.home.dartlen.dindindon.R

class AlarmClock : Worker() {

    override fun doWork(): Result {
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ringtone)
        mediaPlayer.start()
        return Result.SUCCESS
    }
}