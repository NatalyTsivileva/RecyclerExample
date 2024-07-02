package com.practicum.recyclerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicum.recyclerexample.databinding.AcMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

	lateinit var binding: AcMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = AcMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setupUI()
	}

	private fun setupUI() {
		val adapter = OuterAdapter()
		binding.recycler.adapter = adapter
		binding.recycler.layoutManager =
			LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
		adapter.submitList(getRandomDataList())

		binding.deleteBtn.setOnClickListener {
			val newList = adapter.currentList.toMutableList()
			newList.removeFirstOrNull()
			adapter.submitList(newList)
		}

		binding.deleteInnerBtn.setOnClickListener {
			val dataList = adapter.currentList.toMutableList()

			val items = dataList[0].items.toMutableList()
			items.removeFirstOrNull()

			val firstItem = dataList[0].copy(items = items)

			dataList[0] = firstItem

			adapter.submitList(dataList)
		}
	}


	private fun getRandomDataList() = (1..10).map {
		Data(
			id = it,
			header = "Header$it",
			items = (1..Random.nextInt(20)).map { item -> item }
		)
	}


}