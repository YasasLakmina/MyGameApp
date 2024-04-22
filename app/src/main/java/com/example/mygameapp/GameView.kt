package com.example.mygameapp

import android.content.Context
import android.view.SurfaceView
import com.heyletscode.ihavetofly.Background


class GameView(context: Context) : SurfaceView(context), Runnable {

    private var thread: Thread? = null
    private var isPlaying = false // Use lowercase for variable names
    private lateinit var background1 : Background
    private lateinit var background2 : Background

    override fun run() {
        while (isPlaying){
            update();
            draw();
            sleep();
        }
    }
    fun update(){}
    fun draw(){}
    fun sleep(){
        try {
            Thread.sleep(17);
        }catch(e: Exception){
            e.printStackTrace()
        }


    }


    fun resume() {
        isPlaying = true
        thread = Thread(this) // No need for 'new' keyword
        thread?.start() // Use safe call operator ?.
    }

    fun pause() {
        try {
            isPlaying = false
            thread?.join() // Use safe call operator ?.
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
