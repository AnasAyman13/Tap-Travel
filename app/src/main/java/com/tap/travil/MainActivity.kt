package com.tap.travil

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.tap.travil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cities = arrayListOf<cities>()
        cities.add((cities(R.drawable.paris, "Paris","https://youtu.be/NbykpCSi8_0")))
        cities.add((cities(R.drawable.maldive,"Maldive","https://youtu.be/wF3YP0Wb29g")))
        cities.add(cities(R.drawable.london,"London","https://youtu.be/NYY2ELEH0AA?si=Z0hf93cS0BFhoFi1"))
        cities.add(cities(R.drawable.luxor,"Luxor","https://youtu.be/Xm5WyKzq_Eg?si=R-uQVyW1ely1tWg_"))
        cities.add(cities(R.drawable.book_enhanced,"Book now","https://www.booking.com"))

        val adapter = CityAdapter(this ,cities)
        val rv : RecyclerView = binding.rv
        rv.adapter =adapter


        onBackPressedDispatcher.addCallback(this) {
            val exit = ExitDialog()
            exit.isCancelable=false
            exit.show(supportFragmentManager, "exit")
        }

    }



}