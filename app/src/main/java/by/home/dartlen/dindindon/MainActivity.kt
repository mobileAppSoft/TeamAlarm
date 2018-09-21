package by.home.dartlen.dindindon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.home.dartlen.dindindon.list.UsersFragment
import org.json.JSONArray
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userFrag: Fragment = UsersFragment()
        getSupportFragmentManager().beginTransaction().add(R.id.container, userFrag).commit();

        var fcm = FCMSender()

        var users = JSONArray().put(arrayListOf("cATC45HaBDE:APA91bEucpTh1fc3AXLWE9he9HXGdWTKx1kgfD_eb1LB__ytY24rjxgE4cbGVsLilBX6Yx1"))
        var time = Timestamp(100002)
        fcm.FcmSend(users, "Title", "Message", time)
    }
}
