package com.practicum.recyclerexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.practicum.recyclerexample.databinding.ItemOuterBinding

class OuterAdapter : ListAdapter<Data, OuterAdapter.Holder>(OuterCallback) {

	class Holder(private val binding: ItemOuterBinding) : ViewHolder(binding.root) {
		fun bind(data: Data) {
			binding.header.text = data.header

			val adapter = InnerAdapter()
			binding.recycler.adapter = adapter
			binding.recycler.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
			adapter.submitList(data.items)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_outer, parent, false)
		val binding = ItemOuterBinding.bind(view)
		return Holder(binding)
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(currentList[position])
	}


	companion object OuterCallback : DiffUtil.ItemCallback<Data>() {
		override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
			return oldItem == newItem
		}

		override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
			return oldItem.id == newItem.id
		}

	}

}