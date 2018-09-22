package by.home.dartlen.dindindon

import com.google.firebase.database.FirebaseDatabase

class MyDatabaseUtil private constructor() {

    init {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabase.setPersistenceEnabled(true)
        println("init complete")
    }

    companion object {
        lateinit var mDatabase: FirebaseDatabase

        init {
            MyDatabaseUtil()
        }
    }
}