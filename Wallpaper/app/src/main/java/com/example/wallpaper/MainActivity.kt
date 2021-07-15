package com.example.wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var wallpaperList = arrayOf(
        R.drawable.w1,
        R.drawable.w2,
        R.drawable.w3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeWallpaper: Button = findViewById(R.id.change_wallpaper)
        changeWallpaper.setOnClickListener {
            setWallPaper()

        }
    }

    private fun setWallPaper() {
        Handler().postDelayed({
            while(true){
                for (i in wallpaperList) {
                    val bitmap: Bitmap = BitmapFactory.decodeResource(resources, i)
                    val wallpaperManager = WallpaperManager.getInstance(baseContext)
                    wallpaperManager.setBitmap(bitmap)
                }
            }

        }, 10000)
    }
}

