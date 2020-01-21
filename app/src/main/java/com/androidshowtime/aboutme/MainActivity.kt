package com.androidshowtime.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        done_button.setOnClickListener {
            nickname_text.text = nickname_edit.text

            //modifying views visibility
            nickname_edit.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE

            //using it to call the extension fxn
            it.hideKeyboard()
        }

        nickname_text.setOnClickListener {

            updateNickName(it)
        }
    }

    //extension fxn on View class
    private fun View.hideKeyboard() {

        //obtaining inputMethodManager
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        //hideSoftInputFromWindow
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }




    private fun updateNickName(view: View) {

        view.visibility = View.GONE

        done_button.visibility = View.VISIBLE

        nickname_edit.visibility = View.VISIBLE

        //requesting focus for the editTextView
        nickname_edit.requestFocus()

        //using the inputMethodManager to show keyboard
        val inputManager = getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputManager.showSoftInput(nickname_edit, 0)

    }

    private fun addNickname(view: View) {

        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        view.hideKeyboard()


    }
}
