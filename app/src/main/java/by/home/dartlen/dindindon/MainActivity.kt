package by.home.dartlen.dindindon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.home.dartlen.dindindon.list.UsersFragment
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
       // val userFrag: Fragment = UsersFragment()
       // getSupportFragmentManager().beginTransaction().add(R.id.container, userFrag).commit();
    }
}
