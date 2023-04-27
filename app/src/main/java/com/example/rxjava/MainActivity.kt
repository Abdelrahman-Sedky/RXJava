package com.example.rxjava

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private var count = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		addCallbacks()
	}

	private fun addCallbacks() {
		binding.open.setOnClickListener {
			val intent = Intent(
				this,
				SecondActivity::class.java
			).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
			startActivity(intent)
		}

		binding.increment.setOnClickListener {
			count += 1
			Counter.emit(count)
		}

		binding.decrement.setOnClickListener {
			count -= 1
			Counter.emit(count)
		}
	}
}