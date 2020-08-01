package com.appdevgenie.todo_testing_kotlin.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appdevgenie.todo_testing_kotlin.data.Todo
import com.appdevgenie.todo_testing_kotlin.data.TodoRepository


class ListViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val allTodos: LiveData<List<Todo>> = todoRepository.getAllTodos()
    val upcomingTodosCount: LiveData<Int> = todoRepository.getUpcomingTodosCount()

    fun toggleTodo(id: String) {
        todoRepository.toggleTodo(id)
    }

}