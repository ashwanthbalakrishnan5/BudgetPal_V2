package com.solvingforIndia.BudgetPal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.transition.Fade
import android.view.Window
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject
import org.jsoup.Connection
import org.jsoup.Jsoup
import java.io.IOException
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull


class LoginActivity : AppCompatActivity() {

    private val networkHandlerThread = HandlerThread("NetworkHandlerThread")


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            // set set the transition to be shown when the user enters this activity
            enterTransition = Fade()
            enterTransition.duration = 500

        }
        super.onCreate(savedInstanceState)
        networkHandlerThread.start()
        setContentView(R.layout.activity_login_primary)
    }

    fun login(username: String, password: String) {
        val screen = findViewById<FragmentContainerView>(R.id.fragment_container_view)
        if (username.isBlank()) {
            Snackbar.make(screen, "Please enter a username", Snackbar.LENGTH_SHORT).show()
        } else if (password.isBlank()) {
            Snackbar.make(screen, "Please enter a password", Snackbar.LENGTH_SHORT).show()
        } else {
            val sharedPref = getSharedPreferences("config", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("username", username)
                putBoolean("isLoggedIn", true)
                apply()
            }
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun signup(username: String, Password: String){
        //this function will signup to our backend system but first it will make sure that the user has entered a username and password
        // this function is called from the loginFragmment
        val screen = findViewById<FragmentContainerView>(R.id.fragment_container_view)
        if (username.isBlank()){
            Snackbar.make(screen, "Please enter a username", Snackbar.LENGTH_SHORT).show()
        }
        else if (Password.isBlank()){
            Snackbar.make(screen, "Please enter a password", Snackbar.LENGTH_SHORT).show()
        }
        else{
            val sharedPref = getSharedPreferences("config", MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("username", username)
                putBoolean("isLoggedIn", true)
                apply()
            }
            // now we move to the main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

