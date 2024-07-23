/**
 * File name: TodoItem.kt
 * Author: Malkit Kaur
 * Student ID: 200543614
 * Date: 22 July 2024
 * App Description: ToDo List App
 * Version: 2024.1.1
 */


package ca.georgian.assignment3


data class TodoItem(
    val taskName: String,
    val notes: String,
    val dueDate: String,
    val isCompleted: Boolean
)
