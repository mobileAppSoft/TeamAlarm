package by.home.dartlen.dindindon.pendingalarms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.home.dartlen.dindindon.MyDatabaseUtil
import by.home.dartlen.dindindon.R
import by.home.dartlen.dindindon.pendingalarms.util.Alarm
import by.home.dartlen.dindindon.pendingalarms.util.AlarmAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_pendingalarms.*

class PendingAlarmsFragmentJava : Fragment() {
    internal lateinit var myRef: DatabaseReference
    private var x: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(
                R.layout.fragment_pendingalarms, container, false) as ViewGroup
        x = rootView.findViewById<View>(R.id.textView3) as TextView
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter =  AlarmAdapter { item: Alarm -> wtf(item) }

        getNoteList()
    }

    fun wtf(alarm: Alarm) {

    }

    private fun getNoteList() {
        val list = ArrayList<Alarm>()
        // Write a message to the database
        val database = MyDatabaseUtil.mDatabase
        myRef = database.getReference("user_alarms/" + by.home.dartlen.dindindon.pendingalarms.util.Installation.id(context) + "/alarms")

        // Read from the databasef
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.childrenCount == 0L)
                    x!!.visibility = View.VISIBLE
                else
                    x!!.visibility = View.GONE
                Log.e("Count ", "" + snapshot.childrenCount)
                for (postSnapshot in snapshot.children) {
                    val p = postSnapshot.value as Long?
                    val alarm = Alarm(p!!)
                    list.add(alarm)
                }
                (recyclerView.adapter as AlarmAdapter).list = list
                (recyclerView.adapter as AlarmAdapter).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                //Log.w(TAG, "Failed to read value.", error.toException())
            }
        })



    }
}
