package by.home.dartlen.dindindon

import android.media.MediaPlayer
import androidx.work.Worker

class AlarmClock : Worker() {

    override fun doWork(): Result {
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ringtone)
        mediaPlayer.start()
        return Result.SUCCESS
    }
}