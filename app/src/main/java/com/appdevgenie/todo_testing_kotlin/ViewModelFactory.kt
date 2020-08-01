package com.appdevgenie.todo_testing_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appdevgenie.todo_testing_kotlin.add.AddViewModel
import com.appdevgenie.todo_testing_kotlin.data.TodoRepository
import com.appdevgenie.todo_testing_kotlin.list.ListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val todoRepository: TodoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ListViewModel::class.java) ->
                    ListViewModel(todoRepository)
                isAssignableFrom(AddViewModel::class.java) ->
                    AddViewModel(todoRepository)
                else ->
                    throw IllegalArgumentException("ViewModel class (${modelClass.name}) is not mapped")
            }
        } as T
}

