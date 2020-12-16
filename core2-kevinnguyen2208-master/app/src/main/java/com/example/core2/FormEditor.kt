package com.example.core2
//extension included
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class FormEditor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_editor)

        info = intent.getParcelableExtra(MainActivity.PICTURE)!!

        val name = findViewById<EditText>(R.id.name)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val description = findViewById<EditText>(R.id.description)
        val date = findViewById<EditText>(R.id.date)
        val favourite = findViewById<ToggleButton>(R.id.toggleButton)
        val email = findViewById<EditText>(R.id.email)


        name.setText(info.name)
        ratingBar.rating = info.star.toFloat()
        description.setText(info.description)
        date.setText(info.date)
        favourite.isChecked = info.favourite
        email.setText(info.email)



        when (info.id) {
            1 -> R.id.imageButton
            2 -> R.id.imageButton2
            3 -> R.id.imageButton3
            4 -> R.id.imageButton4
        }
    }

    //when back button is pressed
    override fun onBackPressed() {

        info.name = findViewById<EditText>(R.id.name).text.toString()
        info.star = findViewById<RatingBar>(R.id.ratingBar).rating.toDouble().toInt()
        info.description = findViewById<EditText>(R.id.description).text.toString()
        info.date = findViewById<EditText>(R.id.date).text.toString()
        info.email = findViewById<EditText>(R.id.email).text.toString()
        info.favourite = findViewById<ToggleButton>(R.id.toggleButton).isChecked

        //validation of name & email
        if (info.name == "") {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
        }
        else if (info.email == "") {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
        }
        else {
            val i = intent.apply{
                putExtra(RETURN_PICTURE, info)
            }
            setResult(Activity.RESULT_OK, i)
            super.onBackPressed()
        }
    }



    companion object {
        var RETURN_PICTURE = "returnDetail"
        const val P = "picture"
        lateinit var info: Picture
    }
}
