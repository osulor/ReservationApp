package com.example.reservationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_users_list.*

class UsersList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)

        displayExistingUsers()

        delete_button.setOnClickListener {
            MainActivity.sharedPreferences.edit().remove(MainActivity.userNumber + MainActivity.userCount)
            MainActivity.sharedPreferences.edit().commit()
            MainActivity.userCount--
            displayExistingUsers()
        }

    }


    override fun onResume() {
        super.onResume()
        displayExistingUsers()
    }

    private fun displayExistingUsers() {
        Toast.makeText(this,"Current users count is " + MainActivity.userCount.toString(),Toast.LENGTH_LONG).show()
        if (MainActivity.userCount > 0) {
            val myUsers = StringBuilder()
            for (i in 1 until MainActivity.userCount) {
                val user = MainActivity.sharedPreferences.getString(MainActivity.userNumber + i, "")
                myUsers.append(user + "\n")
            }

            infos_textView.setText(myUsers)

        } else {
            infos_textView.text = "No users in"
        }
    }



}
