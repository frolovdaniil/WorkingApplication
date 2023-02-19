package com.example.workingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workingapplication.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity(), ItemAdapter.Listener {



    private lateinit var binding: ActivityItemBinding
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    private val adapter = ItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this@ItemActivity)
        binding.recycler.adapter = adapter
        binding.floatingActionButton.setOnClickListener {
            editLauncher?.launch(Intent(this@ItemActivity, EditActivity::class.java))
        }

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
                Toast.makeText(this@ItemActivity, "plant", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(plant: Plant) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", plant)
        })
    }
}