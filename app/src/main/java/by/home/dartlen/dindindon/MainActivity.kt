package by.home.dartlen.dindindon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        // val userFrag: Fragment = UsersFragment()
        // getSupportFragmentManager().beginTransaction().add(R.id.container, userFrag).commit();


        //val userFrag: Fragment = UsersFragment()
        //supportFragmentManager.beginTransaction().add(R.id.container, userFrag).commit();

        /*var fcm = FCMSender()

        var users = JSONArray().put("d6mDN9o4sEw:APA91bGsPni9cCLObvFTYKSdQ-8fZAXuxCfy3sJCMvZYmAg1urb_KjhEC5w2GHznl-JiIv52pRFKgd4JzgMucJEanVQX-OerY_J4yDfoqSKb6WV2SFk-A5k9esCOXalGfImwApHubdZX")
        var time = "1537567791000"
        fcm.FcmSend(users, "Title", "Message", time)*/
    }


}
