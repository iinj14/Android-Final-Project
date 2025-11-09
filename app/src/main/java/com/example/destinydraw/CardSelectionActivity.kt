package com.example.destinydraw

import UserInfo
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.destinydraw.databinding.ActivityCardBinding

class CardSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBinding

    val allCardNum = listOf(1, 2, 3, 4, 5, 6)

    val cardNum = allCardNum.shuffled()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCard1.setOnClickListener {
            sendResult(cardNum[0])
        }

        binding.btnCard2.setOnClickListener {
            sendResult(cardNum[1])
        }

        binding.btnCard3.setOnClickListener {
            sendResult(cardNum[2])
        }
        binding.btnCard4.setOnClickListener {
            sendResult(cardNum[3])
        }

        binding.btnCard5.setOnClickListener {
            sendResult(cardNum[4])
        }

        binding.btnCard6.setOnClickListener {
            sendResult(cardNum[5])
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