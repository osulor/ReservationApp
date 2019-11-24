package com.example.reservationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editorPreferences: SharedPreferences.Editor
        val USERCOUNT = "KEY"
        val userNumber = "user_"
        var userCount = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.example.reservationapp",
                             Context.MODE_PRIVATE)

        editorPreferences = sharedPreferences.edit()

        submit_button.setOnClickListener {

            userCount++

            val name = name_text.text
            val roomNumber = room_number.text
          //val price = price_text.text.toString()
          //val date = date_text.text.toString()
           val infos = userCount.toString() + " - Name: " + name + " | Room Number: " + roomNumber

            editorPreferences.putString(userNumber + userCount,infos)
            editorPreferences.commit()
            Toast.makeText(this,"Successfull Reservation for user " + userCount,Toast.LENGTH_LONG).show()
            editorPreferences.putInt(USERCOUNT, userCount)
            editorPreferences.commit()
            //displayExistingUsers()
            clearText()
        }


        next_button.setOnClickListener {
            val intent = Intent(this,UsersList::class.java)
            startActivity(intent)
        }
    }


    fun clearText(){
        name_text.setText("")
        room_number.setText("")
        price_text.setText("")
        date_text.setText("")
    }




}
