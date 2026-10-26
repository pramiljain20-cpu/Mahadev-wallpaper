package com.example.mahadev

import android.app.Activity
import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 96, 48, 48)
        }

        layout.addView(TextView(this).apply {
            text = "Mahadev Wallpaper\n\nTap below to set this as your live wallpaper."
            textSize = 18f
        })

        layout.addView(Button(this).apply {
            text = "Set live wallpaper"
            setOnClickListener {
                val intent = Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER).apply {
                    putExtra(
                        WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                        ComponentName(this@MainActivity, MahadevWallpaperService::class.java)
                    )
                }
                startActivity(intent)
            }
        })

        setContentView(layout)
    }
}
