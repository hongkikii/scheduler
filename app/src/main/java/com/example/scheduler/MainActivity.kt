package com.example.scheduler

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var calendarView: CalendarView
    private lateinit var memoTextView: TextView
    private lateinit var todo00TextView: TextView
    private lateinit var todo01TextView: TextView
    private lateinit var todo02TextView: TextView
    private lateinit var todo03TextView: TextView
    private lateinit var todo04TextView: TextView
    private lateinit var todo05TextView: TextView
    private lateinit var todo06TextView: TextView
    private lateinit var todo07TextView: TextView
    private lateinit var todo08TextView: TextView
    private lateinit var todo09TextView: TextView
    private lateinit var todo10TextView: TextView
    private lateinit var todo11TextView: TextView
    private lateinit var todo12TextView: TextView
    private lateinit var todo13TextView: TextView
    private lateinit var todo14TextView: TextView
    private lateinit var todo15TextView: TextView
    private lateinit var todo16TextView: TextView
    private lateinit var todo17TextView: TextView
    private lateinit var todo18TextView: TextView
    private lateinit var todo19TextView: TextView
    private lateinit var todo20TextView: TextView
    private lateinit var todo21TextView: TextView
    private lateinit var todo22TextView: TextView
    private lateinit var todo23TextView: TextView

    private val memoMap = mutableMapOf<String, String>()
    private val todoMap = mutableMapOf<ToDo, String>()

    private lateinit var selectedDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        calendarView = findViewById(R.id.calendarView)
        memoTextView = findViewById(R.id.memoTextView)

        todo00TextView = findViewById(R.id.todo00TextView)
        todo01TextView = findViewById(R.id.todo01TextView)
        todo02TextView = findViewById(R.id.todo02TextView)
        todo03TextView = findViewById(R.id.todo03TextView)
        todo04TextView = findViewById(R.id.todo04TextView)
        todo05TextView = findViewById(R.id.todo05TextView)
        todo06TextView = findViewById(R.id.todo06TextView)
        todo07TextView = findViewById(R.id.todo07TextView)
        todo08TextView = findViewById(R.id.todo08TextView)
        todo09TextView = findViewById(R.id.todo09TextView)
        todo10TextView = findViewById(R.id.todo10TextView)
        todo11TextView = findViewById(R.id.todo11TextView)
        todo12TextView = findViewById(R.id.todo12TextView)
        todo13TextView = findViewById(R.id.todo13TextView)
        todo14TextView = findViewById(R.id.todo14TextView)
        todo15TextView = findViewById(R.id.todo15TextView)
        todo16TextView = findViewById(R.id.todo16TextView)
        todo17TextView = findViewById(R.id.todo17TextView)
        todo18TextView = findViewById(R.id.todo18TextView)
        todo19TextView = findViewById(R.id.todo19TextView)
        todo20TextView = findViewById(R.id.todo20TextView)
        todo21TextView = findViewById(R.id.todo21TextView)
        todo22TextView = findViewById(R.id.todo22TextView)
        todo23TextView = findViewById(R.id.todo23TextView)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$year-${month + 1}-$dayOfMonth"
            displayMemoAndTodoForDate(selectedDate)
        }
    }

    private fun displayMemoAndTodoForDate(selectedDate: String) {
        memoTextView.text = memoMap[selectedDate] ?: ""

        val todoList = mutableListOf<ToDo>()
        todoMap.keys.forEach { todo ->
            if (todo.startDate == selectedDate || todo.endDate == selectedDate) {
                todoList.add(todo)
            }
        }
        displayTodoList(todoList)
    }

    private fun displayTodoList(todoList: List<ToDo>) {
        val todoTextViews = listOf(
            todo00TextView, todo01TextView, todo02TextView, todo03TextView, todo04TextView, todo05TextView,
            todo06TextView, todo07TextView, todo08TextView, todo09TextView, todo10TextView, todo11TextView,
            todo12TextView, todo13TextView, todo14TextView, todo15TextView, todo16TextView, todo17TextView,
            todo18TextView, todo19TextView, todo20TextView, todo21TextView, todo22TextView, todo23TextView
        )

        todoTextViews.forEach { textView ->
            textView.text = ""
        }

        todoList.forEach { todo ->
            val startIndex = todo.startTime.substring(0, 2).toInt()
            val endIndex = todo.endTime.substring(0, 2).toInt()

            if(todo.startDate != todo.endDate) {
                if(selectedDate == todo.startDate) {
                    for (index in startIndex .. 23) {
                        if(index == startIndex) {
                            todoTextViews[index].append("(" + todo.startTime + ") " + todoMap[todo] + "\n")
                        }
                        else {
                            todoTextViews[index].append(todoMap[todo] + "\n")
                        }
                    }
                }
                else if(selectedDate == todo.endDate) {
                    for(index in 0 .. endIndex) {
                        if(index == endIndex) {
                            todoTextViews[index].append(todoMap[todo] +" (" + todo.endTime +")" +"\n")
                        }
                        else {
                            todoTextViews[index].append(todoMap[todo] + "\n")
                        }
                    }
                }
                else if (selectedDate > todo.startDate && selectedDate < todo.endDate) {
                    for (index in 0..23) {
                        todoTextViews[index].append(todoMap[todo] + "\n")
                    }
                }
            }
            else {
                for (index in startIndex..endIndex) {
                    if(index == startIndex && index == endIndex) {
                        todoTextViews[index].append("(" + todo.startTime + ") " + todoMap[todo] + " (" + todo.endTime +")" + "\n")
                    }
                    else if(index == startIndex) {
                        todoTextViews[index].append("(" + todo.startTime + ") " + todoMap[todo] + "\n")
                    }
                    else if(index == endIndex) {
                        todoTextViews[index].append(todoMap[todo] +" (" + todo.endTime +")" + "\n")
                    }
                    else {
                        todoTextViews[index].append(todoMap[todo] + "\n")
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addTodo -> {
                showAddTodoDialog()
                true
            }
            R.id.addMemo -> {
                showAddMemoDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAddTodoDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_todo, null)
        val startDateButton = dialogView.findViewById<Button>(R.id.startDateButton)
        val startTimeButton = dialogView.findViewById<Button>(R.id.startTimeButton)
        val endDateButton = dialogView.findViewById<Button>(R.id.endDateButton)
        val endTimeButton = dialogView.findViewById<Button>(R.id.endTimeButton)
        val todoEditText = dialogView.findViewById<EditText>(R.id.todoEditText)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setTitle("할 일 추가")

        startDateButton.setOnClickListener {
            showDatePickerDialog(startDateButton)
        }

        startTimeButton.setOnClickListener {
            showTimePickerDialog(startTimeButton)
        }

        endDateButton.setOnClickListener {
            showDatePickerDialog(endDateButton)
        }

        startTimeButton.setOnClickListener {
            showTimePickerDialog(startTimeButton)
        }

        endTimeButton.setOnClickListener {
            showTimePickerDialog(endTimeButton)
        }

        builder.setPositiveButton("Add") { _, _ ->
            val startDate = startDateButton.text.toString()
            val startTime = startTimeButton.text.toString()
            val endDate = endDateButton.text.toString()
            val endTime = endTimeButton.text.toString()
            val todo = todoEditText.text.toString()

            selectedDate = startDate

            addTodo(startDate, startTime, endDate, endTime, todo)
            displayMemoAndTodoForDate(selectedDate)

            val calendar = Calendar.getInstance()
            val dateArray = selectedDate.split("-")
            val year = dateArray[0].toInt()
            val month = dateArray[1].toInt() - 1
            val day = dateArray[2].toInt()
            calendar.set(year, month, day)
            val millis = calendar.timeInMillis
            calendarView.setDate(millis, true, true)
        }
        builder.setNegativeButton("Cancel") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }

    private fun addTodo(startDate: String, startTime: String, endDate: String, endTime: String, todo: String) {
        val todoItem = ToDo(
            Random().nextInt(),
            startDate,
            startTime,
            endDate,
            endTime
        )
        addTodo(todoItem, todo)
        displayMemoAndTodoForDate(selectedDate)
    }

    private fun addTodo(todoKey: ToDo, todoValue: String) {
        todoMap[todoKey] = todoValue
    }

    private fun showAddMemoDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_memo, null)
        val memoEditText = dialogView.findViewById<EditText>(R.id.memoEditText)
        val dateButton = dialogView.findViewById<Button>(R.id.dateButton)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setTitle("메모 추가")

        dateButton.setOnClickListener {
            showDatePickerDialog(dateButton)
        }

        builder.setPositiveButton("Add") { _, _ ->
            val memo = memoEditText.text.toString()
            addMemo(selectedDate, memo)
            displayMemoAndTodoForDate(selectedDate)

            val calendar = Calendar.getInstance()
            val dateArray = selectedDate.split("-")
            val year = dateArray[0].toInt()
            val month = dateArray[1].toInt() - 1
            val day = dateArray[2].toInt()
            calendar.set(year, month, day)
            val millis = calendar.timeInMillis
            calendarView.setDate(millis, true, true)
        }
        builder.setNegativeButton("Cancel") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }

    private fun addMemo(date: String, memo: String) {
        memoMap[date] = memo
    }

    private fun showDatePickerDialog(dateButton: Button) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                dateButton.text = selectedDate
            },
            year,
            month,
            dayOfMonth
        )

        datePickerDialog.show()
    }

    private fun showTimePickerDialog(timeButton: Button) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                val timeFormat = "%02d:%02d".format(hourOfDay, minute)
                timeButton.text = timeFormat
            },
            hour,
            minute,
            true
        )

        timePickerDialog.show()
    }
}

class ToDo(
    val randomNumber: Int,
    val startDate: String,
    val startTime: String,
    val endDate: String,
    val endTime: String
)