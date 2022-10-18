package com.trainee.appinventiv.gridtask1.adapter

import android.content.Context
import android.os.Build
import android.view.*
import android.widget.PopupMenu
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trainee.appinventiv.gridtask1.R
import com.trainee.appinventiv.gridtask1.databinding.RvItemBinding


class NewAdapter(val list: ArrayList<String> , val context :Context):ListAdapter<String,NewAdapter.NewHold>( ComparatorDiffUtil() ) {


    inner  class NewHold(private var binding: RvItemBinding):RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(data : String, position: Int) {
            binding.tvName.setText(data)
            binding.tvPositionName.text = position.toString()
            binding.textViewOptions.setOnClickListener {
                showMenu(it,position)
            }

            binding.ccl.setOnClickListener {
                binding.ccl.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
            }
        }

        @RequiresApi(Build.VERSION_CODES.M)
        private fun showMenu(view: View?, position: Int) {
            val popupMenu = PopupMenu(context,view)
            popupMenu.inflate(R.menu.menu_item)
            popupMenu.setGravity(Gravity.CENTER)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(menuItem: MenuItem?): Boolean {
                    when(menuItem?.itemId){
                        R.id.delete ->{
                            list.removeAt(position)
                            //notifyItemRangeChanged(position,list.size)
                            return true
                        }
                        R.id.add ->{
                            list.add(position,"new")
                            //notifyItemRangeChanged(position,list.size)
                            return true
                        }
                        R.id.rename ->{
                            binding.tvName.isEnabled = true
                            return true
                        }
                    }
                    return false
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHold {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewHold(binding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: NewHold, position: Int) {
        holder.bind(list[position],position)
    }

}

class ComparatorDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}