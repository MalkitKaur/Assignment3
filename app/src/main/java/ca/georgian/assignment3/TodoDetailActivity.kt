package ca.georgian.assignment3



import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class TodoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_item)

        val editButton: Button = findViewById(R.id.editButton)

        editButton.setOnClickListener {
            setContentView(R.layout.details_view)

            val taskName = intent.getStringExtra("TASK_NAME")
            val notes = intent.getStringExtra("NOTES")
            val dueDate = intent.getStringExtra("DUE_DATE")
            val isCompleted = intent.getBooleanExtra("IS_COMPLETED", false)

            val taskNameEditText: EditText = findViewById(R.id.taskNameEditText)
            val notesEditText: EditText = findViewById(R.id.notesEditText)
            val datePicker: DatePicker = findViewById(R.id.calendarView)
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
                    datePicker.updateDate(year, month, day)
                }
            }
        }
    }
}
