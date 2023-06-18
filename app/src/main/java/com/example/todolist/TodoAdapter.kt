package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos : MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titletask : TextView
        val check: CheckBox

        init {
            titletask = itemView.findViewById(R.id.textViewTitle)
            check = itemView.findViewById(R.id.checkBoxTask)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.titletask.text = todos[position].title
        holder.check.isChecked = todos[position].isChecked

        holder.itemView.setOnLongClickListener {
            val currentItem = todos[position]

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Delete") { _, _ ->
                    // Delete the item
                    todos.remove(currentItem)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("Cancel", null)
                .show()
            true
        }
    }

    private fun removeItem(position: Int) {
        todos.removeAt(position)
        notifyItemRemoved(position)
    }

}