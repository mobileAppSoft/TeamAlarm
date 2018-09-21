package by.home.dartlen.dindindon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fcm = FCMSender()
        var users = JSONArray()
        var time = Timestamp(100002)
        fcm.FcmSend(users, "Title", "Message", time)
    }
}
