package com.example.e_book

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textTV: TextView
    private lateinit var loadBTN: Button
    private lateinit var toolbarTB: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbarTB = findViewById(R.id.toolBarTB)
        setSupportActionBar(toolbarTB)
        title = "Электронная книга"

        loadBTN = findViewById(R.id.loadBTN)
        textTV = findViewById(R.id.textTV)
        textTV.text = ""

        loadBTN.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    val book = database().text

    override fun onClick(v: View) {
        when(v.id) {
            R.id.loadBTN -> textTV.append(book)
        }

    }

    fun  loadBook(text: String): List<String> {
        return text.split(" ")
    }
}