package com.practicum.recyclerexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.practicum.recyclerexample.databinding.ItemInnerBinding

class InnerAdapter : ListAdapter<Int, InnerAdapter.Holder>(InnerCallback) {

	class Holder(val binding: ItemInnerBinding) : ViewHolder(binding.root) {
		fun bind(item: Int) {
			binding.itemText.text = item.toString()
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inner, parent, false)
		val binding = ItemInnerBinding.bind(view)
		return Holder(binding)
	}

	override fun getItemCount(): Int {
		return currentList.count()
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(currentList[position])
	}

	companion object InnerCallback : DiffUtil.ItemCallback<Int>() {

		override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
			return oldItem == newItem
		}

		override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
			return oldItem == newItem
		}

	}
}