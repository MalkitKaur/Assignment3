package ca.georgian.assignment3

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class TodoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_item)

        val editButton: Button = findViewById(R.id.editButton)

        editButton.setOnClickListener {
            Log.d("TodoDetailActivity", "Edit button clicked")

            setContentView(R.layout.details_view)

            val taskName = intent.getStringExtra("TASK_NAME")
            val notes = intent.getStringExtra("NOTES")
            val dueDate = intent.getStringExtra("DUE_DATE")
            val isCompleted = intent.getBooleanExtra("IS_COMPLETED", false)

            Log.d("TodoDetailActivity", "Task Name: $taskName")
            Log.d("TodoDetailActivity", "Notes: $notes")
            Log.d("TodoDetailActivity", "Due Date: $dueDate")
            Log.d("TodoDetailActivity", "Is Completed: $isCompleted")

            val taskNameEditText: EditText = findViewById(R.id.taskNameEditText)
            val notesEditText: EditText = findViewById(R.id.notesEditText)
            val calendarView: CalendarView = findViewById(R.id.calendarView)
            val switchCompletedDetail: Switch = findViewById(R.id.switchCompletedDetail)

            // Set retrieved data to views
            taskNameEditText.setText(taskName)
            notesEditText.setText(notes)
            switchCompletedDetail.isChecked = isCompleted

            dueDate?.let {
                val parts = it.split("-")
                if (parts.size == 3) {
                    val year = parts[0].toInt()
                    val month = parts[1].toInt() - 1
                    val day = parts[2].toInt()

                    // Set the date on the CalendarView
                    val calendar = java.util.Calendar.getInstance()
                    calendar.set(year, month, day)
                    calendarView.date = calendar.timeInMillis
                }
            }
        }
    }
}
