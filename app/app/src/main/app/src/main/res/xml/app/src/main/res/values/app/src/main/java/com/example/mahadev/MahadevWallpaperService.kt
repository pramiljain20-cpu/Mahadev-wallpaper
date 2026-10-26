package com.example.mahadev

import android.graphics.Color
import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder

class MahadevWallpaperService : WallpaperService() {

    override fun onCreateEngine(): Engine = MahadevEngine()

    inner class MahadevEngine : Engine() {

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            super.onSurfaceCreated(holder)
            drawFrame(holder)
        }

        override fun onSurfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            super.onSurfaceChanged(holder, format, width, height)
            drawFrame(holder)
        }

        private fun drawFrame(holder: SurfaceHolder) {
            val canvas = holder.lockCanvas() ?: return
            try {
                canvas.drawColor(Color.BLACK)
            } finally {
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }
}
