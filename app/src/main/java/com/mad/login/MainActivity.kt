package com.mad.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.mad.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val _email = "admin@example.com"
    private val _password = "admin"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.loginButton.setOnClickListener{ onLogin(it) }
    }

    override fun onResume() {
        super.onResume()
        binding.emailInput.setText("")
        binding.passwordInput.setText("")
    }

    private fun onLogin(button: View) {
        val emailInputText = binding.emailInput.text.toString()
        val passwordInputText = binding.passwordInput.text.toString()
        val errorText = binding.errorMessage
        if (emailInputText == _email && passwordInputText == _password) {
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
