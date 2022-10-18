package com.trainee.appinventiv.gridtask1.adapter


import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.trainee.appinventiv.gridtask1.R
import com.trainee.appinventiv.gridtask1.databinding.RvItemBinding



class NumberAdapter(val context: Context)
    : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {


    private var list : ArrayList<String> = ArrayList()

    fun set(data: ArrayList<String>) {
        list = data
    }

     inner class ViewHolder(private val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data : String, position: Int) {
            binding.tvName.setText(data)
            binding.tvPositionName.text = position.toString()
            binding.textViewOptions.setOnClickListener {
                showMenu(it,position)
            }


            binding.tvName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }

         private fun showMenu(view: View?, position: Int) {
             val popupMenu = PopupMenu(context,view)
             popupMenu.inflate(R.menu.menu_item)
             popupMenu.show()
             popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                 override fun onMenuItemClick(menuItem: MenuItem?): Boolean {
                     when(menuItem?.itemId){
                         R.id.delete ->{
                             list.removeAt(position)
                             notifyItemRemoved(position)
                             return true
                         }
                         R.id.add ->{
                             list.add(position,"new")
                             notifyItemInserted(position)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}










