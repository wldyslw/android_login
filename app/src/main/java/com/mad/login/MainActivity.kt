package com.mad.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private val _email = "admin@example.com"
    private val _password = "admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener{ onLogin(it) }
    }

    private fun onLogin(button: View) {
        val emailInput = findViewById<TextView>(R.id.email_input)
        val passwordInput = findViewById<TextView>(R.id.password_input)
        val errorText = findViewById<TextView>(R.id.error_message)
//        val text = "${emailInput.text}: ${passwordInput.text}"
//        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
//        toast.show()
        if (emailInput.text.toString() == _email && passwordInput.text.toString() == _password) {
            errorText.visibility = View.INVISIBLE
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(button.windowToken, 0)
        } else {
            errorText.visibility = View.VISIBLE
        }
    }
}
