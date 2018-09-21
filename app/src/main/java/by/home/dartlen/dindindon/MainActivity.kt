package by.home.dartlen.dindindon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.home.dartlen.dindindon.list.UsersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userFrag: Fragment = UsersFragment()
        getSupportFragmentManager().beginTransaction().add(R.id.container, userFrag).commit();
    }
}
