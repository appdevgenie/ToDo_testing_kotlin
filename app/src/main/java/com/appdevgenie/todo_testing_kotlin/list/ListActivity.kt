package com.appdevgenie.todo_testing_kotlin.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.appdevgenie.todo_testing_kotlin.R
import com.appdevgenie.todo_testing_kotlin.add.AddActivity
import com.appdevgenie.todo_testing_kotlin.obtainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class ListActivity : AppCompatActivity(), TodoAdapter.OnClickListener {

    override fun onCheckboxChecked(id: String) {
        listViewModel.toggleTodo(id)
    }

    private lateinit var listViewModel: ListViewModel
    private var adapter = TodoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }

        listViewModel = obtainViewModel(ListViewModel::class.java)

        listTodos.layoutManager = LinearLayoutManager(this)
        listTodos.adapter = adapter
        listViewModel.allTodos.observe(this, Observer { todos ->
            todos?.let {
                adapter.setTodos(todos)
            }
        })

        listViewModel.upcomingTodosCount.observe(this, Observer { count ->
            soonValue.text = count.toString()
        })
    }
}
