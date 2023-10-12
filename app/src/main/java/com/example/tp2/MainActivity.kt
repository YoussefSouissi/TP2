package com.example.tp2

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {
    lateinit var btn: Button
    lateinit var page: LinearLayout
    lateinit var img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btn = findViewById(R.id.btn)
        page = findViewById(R.id.container)
        img = findViewById(R.id.imageView)

        btn.setOnClickListener { showPopupMenu() }
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(this, btn)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.red -> {
                    page.setBackgroundColor(Color.RED)
                }
                R.id.blue -> {
                    page.setBackgroundColor(Color.BLUE)
                }
                R.id.green -> {
                    page.setBackgroundColor(Color.GREEN)
                }
                R.id.yellow -> {
                    page.setBackgroundColor(Color.YELLOW)
                }
                R.id.gray -> {
                    page.setBackgroundColor(Color.GRAY)
                }
                R.id.pop_men -> {
                    val itemText = item.title.toString()
                    val message = "This is $itemText"
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
                R.id.helloworld -> {
                    val itemTxt = item.title.toString()
                    Toast.makeText(this, itemTxt, Toast.LENGTH_LONG).show()
                }
                R.id.phone -> {
                    img.setImageResource(R.drawable.tel)
                }
                R.id.wifi -> {
                    img.setImageResource(R.drawable.wifiimg)
                }
            }
            true
        }

        popupMenu.show()
    }
}
