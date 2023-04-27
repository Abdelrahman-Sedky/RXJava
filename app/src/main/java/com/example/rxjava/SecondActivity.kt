package com.example.rxjava

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

	private lateinit var binding: ActivitySecondBinding

	@SuppressLint("CheckResult")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySecondBinding.inflate(layoutInflater)
		setContentView(binding.root)

		Counter.listen().subscribe {
			binding.counter.text = it.toString()
		}

		binding.back.setOnClickListener {
			val intent = Intent(
				this,
				MainActivity::class.java
			).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
			startActivity(intent)
		}
	}
}