package com.example.destinydraw

import UserInfo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.destinydraw.databinding.ActivityMainBinding
import androidx.activity.result.contract.ActivityResultContracts
import android.text.Editable
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFortune.isEnabled = false

        binding.edtName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val isNameValid = !s.isNullOrBlank()
                binding.btnFortune.isEnabled = isNameValid
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.btnFortune.setOnClickListener {
            val intent = Intent(this, CardSelectionActivity::class.java)
            cardSelectionLauncher.launch(intent)
        }
    }
    private val cardSelectionLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val selectedCardNum = data?.getIntExtra("selectedCardNum", 0) ?: 0

            if (selectedCardNum != 0) {
                val user = UserInfo(
                    name = binding.edtName.text.toString(),
                    cardNum = selectedCardNum
                )
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("extra_user", user)
                }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }


}
