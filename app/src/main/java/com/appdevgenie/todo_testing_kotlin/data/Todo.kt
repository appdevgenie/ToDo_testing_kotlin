package com.appdevgenie.todo_testing_kotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(

    @PrimaryKey var id: String,
    var title: String,
    var dueDate: Long?,
    var completed: Boolean,
    var created: Long
)