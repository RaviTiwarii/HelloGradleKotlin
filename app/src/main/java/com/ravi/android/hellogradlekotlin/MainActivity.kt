package com.ravi.android.hellogradlekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputName: TextInputLayout = findViewById(R.id.name_field)
        val textViewGreeting: MaterialTextView = findViewById(R.id.tv_message)
        val buttonGreet: MaterialButton = findViewById(R.id.btn_greet)

        buttonGreet.setOnClickListener {
            val name = textInputName.editText?.text.toString()
            if (name.isBlank()) {
                textInputName.error = getString(R.string.error_blank_name)
                return@setOnClickListener
            }
            textViewGreeting.text = Greeter(name).greet()
            textInputName.editText?.setText("")
            textInputName.clearFocus()
        }
    }

    class Greeter(private val name: String) {
        fun greet() = "Hello, $name!"
    }
}