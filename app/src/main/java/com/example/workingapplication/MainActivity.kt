package com.example.workingapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workingapplication.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), CurrentAdapter.Listener {

    private lateinit var binding: ActivityMainBinding
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    private val adapter = CurrentAdapter(this)
    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.d(TAG, "MyApp onCreate")

        if(savedInstanceState == null) {

        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recycler.adapter = adapter

            binding.floatingActionButton.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, ContentActivity::class.java))
                val intent = Intent(this, ItemActivity::class.java)
                startActivity(intent)
            }

        var sss = intent.getSerializableExtra("str") as Plant?
        if (sss != null) {
            adapter.addItem(sss)
        }

        }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putString("KEY", binding.textView.toString())
            putSerializable("K", intent.getSerializableExtra("str") as Plant?)
            Log.d(TAG, "MyApp onSaveInstanceState")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d(TAG, "MyApp onRestoreInstanceState")

        adapter.addItem(savedInstanceState.getSerializable("K") as Plant)
    }

    override fun onClick(plant: Plant) {

    }

    override fun onPause() {
        Log.d(TAG, "MyApp onPause")
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
