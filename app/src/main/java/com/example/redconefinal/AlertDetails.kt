package com.example.redconefinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.redconefinal.databinding.ActivityAlertDetailsBinding

class AlertDetails : AppCompatActivity() {
    private lateinit var binding: ActivityAlertDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>("user")

        if (user != null) {
            binding.nameTextView.text = user.name
            binding.locationTextView.text = user.Location
            binding.datetimeTextView.text = user.datetime

            Glide.with(this)
                .load(user.image)
                .into(binding.imageView)
        } else {
            Toast.makeText(this, "User data not found", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
