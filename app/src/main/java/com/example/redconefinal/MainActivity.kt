package com.example.redconefinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        // Set click listener for the button
        findViewById<View>(R.id.startButton).setOnClickListener {
            secondpage(it)
        }

        // Subscribe all users to the 'all_users' topic
        FirebaseMessaging.getInstance().subscribeToTopic("all_users")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("MainActivity", "Subscribed to topic 'all_users'")
                } else {
                    Log.e("MainActivity", "Failed to subscribe to topic 'all_users'", task.exception)
                }
            }

        // Retrieve the FCM token (optional)
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.e("FirebaseMsgService", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("FirebaseMsgService", "FCM registration token: $token")
        }
    }

    fun secondpage(view: View) {
        val intent = Intent(this, AlertData::class.java)
        startActivity(intent)
    }
}
