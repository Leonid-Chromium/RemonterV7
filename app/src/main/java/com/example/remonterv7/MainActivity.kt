package com.example.remonterv7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlin.collections.ArrayList as ArrayList1

class MainActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var taskRecycleView : RecyclerView
    private lateinit var taskArrayList : ArrayList1<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskRecycleView = findViewById(R.id.taskList)
        taskRecycleView.layoutManager = LinearLayoutManager(this)
        taskRecycleView.setHasFixedSize(true)

        taskArrayList = arrayListOf()
        getTaskData()
    }

    private fun getTaskData() {

        dbref = FirebaseDatabase.getInstance().getReference("Task")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (taskSnapshot in snapshot.children) {

                        val task = taskSnapshot.getValue(Task::class.java)
                        taskArrayList.add(task!!)

                    }

                    taskRecycleView.adapter = MyAdapter(taskArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {

            //val toast = Toast.makeText(applicationContext, "Пора покормить кота!", Toast.LENGTH_SHORT)
            //toast.show()
            }

        })
    }
}