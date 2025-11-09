package com.example.destinydraw

import UserInfo
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.destinydraw.databinding.ActivityCardBinding

class CardSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCard1.setOnClickListener {
            sendResult(1)
        }

        binding.btnCard2.setOnClickListener {
            sendResult(2)
        }

        binding.btnCard3.setOnClickListener {
            sendResult(3)
        }

    }

    private fun sendResult(cardNum: Int) {
        val resultIntent = Intent().apply {

            putExtra("selectedCardNum", cardNum)
        }
        setResult(RESULT_OK, resultIntent)
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}