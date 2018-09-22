package by.home.dartlen.dindindon

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.alarm_activity.*

class AlarmActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_activity)
    }

    override fun onStart() {
        super.onStart()

        setupAudio()

        cancel.setOnClickListener {
            finishActivity()
        }
    }

    private fun setupAudio() {

        try {
            val player = MediaPlayer.create(this, R.raw.ringtone)
            player.isLooping = true // Set looping

            player.setVolume(100f, 100f)
            player.start()
        } catch (e: Exception) {
            //showErrorToast(e)
        }
    }

    private fun finishActivity() {
        destroyPlayer()
        finish()
        overridePendingTransition(0, 0)
    }

    private fun destroyPlayer() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}