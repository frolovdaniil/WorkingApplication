package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.workingapplication.databinding.ActivityContentBinding
import com.example.workingapplication.databinding.ActivityMainBinding

class ContentActivity : AppCompatActivity(), CurrentAdapter.Listener {

    private lateinit var binding: ActivityContentBinding
    private val TAG: String = "ContentActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MyApp onCreate()")

        val item = intent.getSerializableExtra("item") as Plant

        binding.apply {
            tvTitle.text = "Название: ${item.title}"
            tvContent.text = "Цена: ${item.price}"
        }

        binding.floatingActionButton3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra("str", item)
            })
        }
    }

    override fun onClick(plant: Plant) {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        Log.d(TAG, "MyApp onPause()")
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "MyApp onResume()")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG, "MyApp onStop()")
        super.onStop()
    }

    override fun onStart() {
        Log.d(TAG, "MyApp onStart()")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG, "MyApp onRestart()")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "MyApp onDestroy()")
        super.onDestroy()
    }

}