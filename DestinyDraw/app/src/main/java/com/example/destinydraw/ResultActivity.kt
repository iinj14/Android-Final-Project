package com.example.destinydraw

import UserInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.destinydraw.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<UserInfo>("extra_user")
        binding.txtFortune.text = generateText(user)
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun generateText(user: UserInfo?): String {
        if (user == null) return "No fortune data found."

        val cardNum = user.cardNum
        val name = user.name

        val fortuneList = when (cardNum) {
            1 -> listOf(
                "Happiness brings you luck today!",
                "Someone will smile because of you 😊"
            )
            2 -> listOf(
                "Better days are coming, $name 💛",
                "Don’t worry too much — you’re stronger than you think."
            )
            else -> listOf(
                "Something wonderful is on its way 🌈",
                "Stay curious — new chances will appear soon!"
            )
        }

        val randomFortune = fortuneList.random()

        return """
        Hi $name 🍀
        ✨ Today's Fortune ✨
        "$randomFortune"
    """.trimIndent()
    }

}
