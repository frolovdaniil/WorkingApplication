package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workingapplication.databinding.ActivityItemBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemActivity : AppCompatActivity(), ItemAdapter.Listener {


    private val TAG: String = ItemActivity::class.java.simpleName
    private lateinit var binding: ActivityItemBinding
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    private val adapter = ItemAdapter(this)
    var arrl = ArrayList<Plant>()
    var arrlaa = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        binding.recycler.layoutManager = LinearLayoutManager(this@ItemActivity)
        binding.recycler.adapter = adapter
        binding.floatingActionButton.setOnClickListener {
            editLauncher?.launch(Intent(this@ItemActivity, EditActivity::class.java))
        }

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
                saveData()
                Log.d(TAG, "MyApp current data in adapter = ${adapter.plantList}")
            }
        }

    }



    override fun onClick(plant: Plant) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", plant)
        })
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task list", "")
        val type = object : TypeToken<ArrayList<Plant>>() {}.type

        if (json == null) {
            Toast.makeText(this@ItemActivity, "loadData() json: null", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@ItemActivity, "loadData() json not null: = $json" , Toast.LENGTH_SHORT).show()
            adapter.plantList = gson.fromJson<Plant>(json, type)
            adapter.notifyDataSetChanged()

            Log.d(TAG, "MyApp loading data = ${gson.fromJson<Plant>(json, type)}")
        }
    }

    fun saveData(){
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(adapter.plantList)
        editor.putString("task list", json)
        editor.apply()
        Log.d(TAG, "MyApp data was saved = $json" )

    }
}