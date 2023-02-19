package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workingapplication.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton2.setOnClickListener {
            val plant = Plant(binding.edTitle.text.toString(), binding.editTextNumber.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }


}