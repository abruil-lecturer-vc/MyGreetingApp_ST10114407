package com.example.mygreetingapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /*
    * enum class is a special type of class that
    * represents a fixed set of constants.
    * Each enum class is used to define a group of related
    * constants that share a common purpose.
    * */
    enum class Languages
    {
        ENGLISH,
        NDEBELE,
        PEDI,
        SOTHO,
        SWATI,
        TSONGA,
        TSWANA,
        VENDA,
        XHOSA,
        ZULU,
        AFRIKAANS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the components using the ID on the user interface
        val clickMeButton = findViewById<Button>(R.id.btnClick)
        val greetingText = findViewById<TextView>(R.id.txtGreeting)
        val editNameText = findViewById<EditText>(R.id.edtUserName)
        val zuluSwitch = findViewById<Switch>(R.id.switchZulu)
        val languageSpinner = findViewById<Spinner>(R.id.spinnerLang)


        // Set up the spinner options
        languageSpinner.adapter = ArrayAdapter<MainActivity.Languages>(this,
            android.R.layout.simple_list_item_1, Languages.values()
        )

        var greeting: String = ""

        // Add code to the button that happens when it is clicked
        clickMeButton?.setOnClickListener {
            var greeting: String = ""
            val name = editNameText.text.toString()

            // Logical operator
            var zulu: Boolean = zuluSwitch.isChecked()

            // If statement checks whether the Zulu switch has been checked
            if (zulu) {
                // If the switch has been checked, change the greeting to Zulu
                greeting = "Sawubona, ${name}!"
            }
            else // If the switch is not checked, the greeting will become English
            {
                // Nested If-else statement
                // If the user's name is Sam or Samantha
                if ((name == "Sam" ||  name == "Samantha"))
                {
                    greeting = "Yo, ${name}!"
                }
                else
                {
                    // If the name is not Sam or Samantha
                    greeting = "Greetings, ${name}!"
                }
            }

            /* LOGIC FOR SPINNER */
            val language = languageSpinner.selectedItem as Languages

            // When statement to check which language is selected in the spinner
            greeting = when (language) {
                Languages.ZULU -> "Sawubona, $name"
                Languages.AFRIKAANS -> "Groete, $name"
                Languages.SOTHO -> "DUMELA, $name"
                else -> "Greetings, $name"
            }

            Log.d("name", greeting)
            // Set the greeting text on the Screen
            greetingText.text = greeting

        }
    }
}