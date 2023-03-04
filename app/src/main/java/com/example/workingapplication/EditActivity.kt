package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workingapplication.databinding.ActivityEditBinding
import com.google.gson.Gson
import kotlin.reflect.typeOf

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    var arrl = ArrayList<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton2.setOnClickListener {
            val plant = Plant(binding.edTitle.text.toString(), binding.editTextNumber.text.toString())
            arrl.add(plant)
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

}