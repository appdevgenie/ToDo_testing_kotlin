package com.appdevgenie.todo_testing_kotlin.add

import androidx.lifecycle.ViewModel
import com.appdevgenie.todo_testing_kotlin.data.Todo
import com.appdevgenie.todo_testing_kotlin.data.TodoRepository
import java.util.*

class AddViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todo = Todo(
        UUID.randomUUID().toString(),
        "",
        null,
        false,
        0
    )


    fun save(): String? {
        if (todo.title == "") return "Title is required"

        todo.created = System.currentTimeMillis()
        todoRepository.insert(todo)
        return null
    }

}