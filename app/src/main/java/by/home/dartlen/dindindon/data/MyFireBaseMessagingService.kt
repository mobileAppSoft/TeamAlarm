package by.home.dartlen.dindindon.data

import android.util.Log
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import by.home.dartlen.dindindon.list.Person
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.accounts.AccountManager
import by.home.dartlen.dindindon.Constants.TIME_ALARM
import by.home.dartlen.dindindon.worker.SetAlarmWorker
import java.util.*

class MyFireBaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage!!.data.isNotEmpty()) {

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.

                val setAlarmWork = OneTimeWorkRequest.Builder(SetAlarmWorker::class.java)
                        .setInputData(createInputData(remoteMessage.data["time"]!!.toLong()))
                        .build()
                WorkManager.getInstance().enqueue(setAlarmWork)
            } else {
                // Handle message within 10 seconds
                //handleNow()
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage!!.notification != null) {
            //Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    fun createInputData(time: Long): Data {
        return Data.Builder()
                .putLong(TIME_ALARM, time)
                .build()
    }

    override fun onNewToken(token: String) {
        //Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //ediNUlBd8Ls:APA91bH2s6p98weNGSlhXMeMAYu2RM4D7Ro5mWotj0vdJxPaPn2YVNmSLnwDdfTdhJpI5K0Doc7iQdNallCMVkhLtHkHoPMg6mvgWX9tNvF0sRDFEr166XexvqmKFbEdrYaNGiMVPZrb
        sendRegistrationToServer(token)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("names")

        val accounts = AccountManager.get(this).accounts

        var name = "Vasia ${Date().time}"
        if (accounts.isNotEmpty()) {
            name = accounts[0].name
        }

        myRef.push().setValue(Person(name, token))
            .addOnSuccessListener {
                Log.d("TOKEN","writed")
            }.addOnFailureListener {
                        Log.d("TOKEN","NOT writed")
                    }

    }

    private fun sendRegistrationToServer(token: String?) {
        // TODO: Implement this method to send token to your app server.
    }

}



