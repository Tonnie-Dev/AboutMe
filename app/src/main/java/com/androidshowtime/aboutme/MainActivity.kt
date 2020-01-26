package com.androidshowtime.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.androidshowtime.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.doneButton.setOnClickListener {


            binding.apply{
                nicknameText.text = nickname_edit.text

                //modifying views visibility
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE

            }


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

        binding.doneButton.visibility = View.GONE

        binding.doneButton.visibility = View.VISIBLE

        binding.nicknameEdit.visibility = View.VISIBLE

        //requesting focus for the editTextView
        binding.nicknameEdit.requestFocus()

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
