package by.home.dartlen.dindindon

import android.util.Log

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.sql.Timestamp

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class FCMSender {

    private val API_KEY = "AIzaSyCcuJt3fvpRvO-wBvKnnrvLi7nShXWTL5c"

    public fun FcmSend(recipients: JSONArray, title: String,  message: String, alarmTIme: Timestamp) {
        Thread(Runnable {
            try {
                val root = JSONObject()
                val notification = JSONObject()
                try {
                    root.put("registration_ids", recipients)

                    notification.put("title", title)
                    notification.put("time", alarmTIme)  //new SimpleDateFormat("EEE(MMM dd)HH:mm:ss").format(new Date()));

                    root.put("data", notification)
                    println(root)
                } catch (e: JSONException) {
                    println("Unable to Json conversion")
                    e.printStackTrace()
                }

                val client = OkHttpClient()
                val FCM_MESSAGE_URL = "https://fcm.googleapis.com/fcm/send"
                val JSON = MediaType.parse("application/json; charset=utf-8")

                val body = RequestBody.create(JSON, root.toString())
                val request = Request.Builder()
                        .url(FCM_MESSAGE_URL)
                        .post(body)
                        .addHeader("Authorization", "key=$API_KEY")
                        .build()
                val response = client.newCall(request).execute()

                val result = response.body().string()
                Log.d("tag", result);
            } catch (e: IOException) {
                println("Unable to send GCM message.")
                println("Please ensure that API key, and that the device's registration token is correct (if specified).")
                e.printStackTrace()

                Log.d("CallinsFCMSen", "!!!!!!finishFCMSend_EXCEPTION!!!!!")
            }
        }).start()
    }
}