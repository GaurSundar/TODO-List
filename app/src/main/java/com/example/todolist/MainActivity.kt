package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var editText: EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("message" , "OnCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycle)
        editText = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)

        var todolist = mutableListOf(
            Todo("Learn Android" , false),
            Todo("Learn RecyclerView" , true),
            Todo("Learn Fragments" , false),
            Todo("Learn MVVM" , false),
            Todo("Learn Dependency" , false),
            Todo("Learn Web" , false),
            Todo("Learn Node" , false)
        )
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        val Myadapter = TodoAdapter(todolist)
        recyclerView.adapter = Myadapter

        button.setOnClickListener {
            val task = editText.text.toString()
            val todo = Todo(task , false)
            todolist.add(todo)
            Myadapter.notifyItemInserted(todolist.size-1)

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("message" , "Onstart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("message" , "Onresume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("message" , "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("message" , "Onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("message" , "ondestroy")
    }
}