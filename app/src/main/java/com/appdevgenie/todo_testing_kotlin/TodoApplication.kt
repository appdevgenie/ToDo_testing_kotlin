package com.appdevgenie.todo_testing_kotlin

import android.app.Application
import com.appdevgenie.todo_testing_kotlin.data.TodoRepository
import com.appdevgenie.todo_testing_kotlin.data.TodoRoomDatabase
import com.appdevgenie.todo_testing_kotlin.data.TodoRoomRepository

class TodoApplication : Application() {

    val todoRepository: TodoRepository
        get() = TodoRoomRepository(TodoRoomDatabase.getInstance(this.applicationContext)!!.todoDao())
}