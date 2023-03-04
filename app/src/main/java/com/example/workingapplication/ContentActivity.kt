package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.workingapplication.databinding.ActivityContentBinding
import com.example.workingapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContentActivity : AppCompatActivity(), CurrentAdapter.Listener {

    private lateinit var binding: ActivityContentBinding
    private val TAG: String = "ContentActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val v = SharedPref.getValue(this)

        Log.d(TAG, "MyApp onCreate()")

        var item = intent.getSerializableExtra("item") as Plant
        val s = SharedPref.setValue(this, item)

        binding.apply {
            tvTitle.text = "Название: ${item.title}"
            tvContent.text = "Цена: ${item.price}"
        }



        binding.floatingActionButton3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra("str", item)
                finish()
            })
        }



    }





    override fun onClick(plant: Plant) {
        TODO("Not yet implemented")
    }

}