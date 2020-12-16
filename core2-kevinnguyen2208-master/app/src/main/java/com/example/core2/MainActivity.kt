package com.example.core2
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mint: Picture = Picture("mint", "Nice Mint","1/09/2019", false, "mint@gmail.com", 2, 1)
    private var chocolate: Picture = Picture("chocolate", "Nice Chocolate", "19/08/2017", false, "chocolate@gmail.com", 3, 2)
    private var strawberry: Picture = Picture("strawberry", "Nice Strawberry","21/04/2015", false, "strawberry@gmail.com", 4, 3)
    private var vanilla: Picture = Picture("vanilla", "Nice Vanilla", "30/10/2011", false, "vanilla@gmail.com",5, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mintImage = findViewById<ImageButton>(R.id.imageButton)
        val mintName = findViewById<TextView>(R.id.name1)
        mintName.text = mint.name
        val mintRate = findViewById<TextView>(R.id.rate1)
        mintRate.text = mint.star.toString()
        mintImage.setOnClickListener(){
            val i = Intent(this, FormEditor::class.java).apply{
            putExtra(PICTURE, mint)
        }
            startActivityForResult(i, 0)
        }

        val chocolateImage = findViewById<ImageButton>(R.id.imageButton2)
        val chocolateName = findViewById<TextView>(R.id.name2)
        chocolateName.text = chocolate.name
        val chocolateRate = findViewById<TextView>(R.id.rate2)
        chocolateRate.text = chocolate.star.toString()
        chocolateImage.setOnClickListener(){
            val i = Intent(this, FormEditor::class.java).apply{
                putExtra(PICTURE, chocolate)
            }
            startActivityForResult(i, 1)
        }

        val strawberryImage = findViewById<ImageButton>(R.id.imageButton3)
        val strawberryName = findViewById<TextView>(R.id.name3)
        strawberryName.text = strawberry.name
        val strawberryRate = findViewById<TextView>(R.id.rate3)
        strawberryRate.text = strawberry.star.toString()
        strawberryImage.setOnClickListener(){
            val i = Intent(this, FormEditor::class.java).apply{
                putExtra(PICTURE, strawberry)
            }
            startActivityForResult(i, 2)
        }

        val vanillaImage = findViewById<ImageButton>(R.id.imageButton4)
        val vanillaName = findViewById<TextView>(R.id.name4)
        vanillaName.text = vanilla.name
        val vanillaRate = findViewById<TextView>(R.id.rate4)
        vanillaRate.text = vanilla.star.toString()
        vanillaImage.setOnClickListener(){
            val i = Intent(this, FormEditor::class.java).apply{
                putExtra(PICTURE, vanilla)
            }
            startActivityForResult(i, 3)
        }
        Log.d("initializing", "Creating data")
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

        super.onActivityResult(requestCode, resultCode, intent)
        if (intent == null) Log.i("MAIN IS RECEIVING", "IS NULL")
        if (resultCode != Activity.RESULT_OK) return
        if (requestCode == 0) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name1 = findViewById<TextView>(R.id.name1)
            val star1 = findViewById<TextView>(R.id.rate1)
            data?.let{
                mint.name = data.name
                mint.star = data.star
                star1.text = mint.star.toString()
                name1.text = mint.name
                mint.description = data.description
                mint.email = data.email
                mint.date = data.date
                mint.favourite = data.favourite
            }
        }

        else if (requestCode == 1) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name2 = findViewById<TextView>(R.id.name2)
            val star2 = findViewById<TextView>(R.id.rate2)
            data?.let {
                chocolate.name = data.name
                chocolate.star = data.star
                star2.text = chocolate.star.toString()
                name2.text = chocolate.name
                chocolate.description = data.description
                chocolate.email = data.email
                chocolate.date = data.date
                chocolate.favourite = data.favourite
            }
        }

        else if (requestCode == 2) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name3 = findViewById<TextView>(R.id.name3)
            val star3 = findViewById<TextView>(R.id.rate3)
            data?.let{
                strawberry.name = data.name
                strawberry.star = data.star
                star3.text = strawberry.star.toString()
                name3.text = strawberry.name
                strawberry.description = data.description
                strawberry.email = data.email
                strawberry.date = data.date
                strawberry.favourite = data.favourite
            }
        }

        else if (requestCode == 3) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name4 = findViewById<TextView>(R.id.name4)
            val star4 = findViewById<TextView>(R.id.rate4)
            data?.let {
                vanilla.name = data.name
                vanilla.star = data.star
                star4.text = vanilla.star.toString()
                name4.text = vanilla.name
                vanilla.description = data.description
                vanilla.email = data.email
                vanilla.date = data.date
                vanilla.favourite = data.favourite
            }
        }

        else {
            Log.e("Intent", "Failed retrieval")
        }
    }



    companion object {
        const val PICTURE = "info"
    }
}

