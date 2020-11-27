package com.example.myfirstapp

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    // instance of SoundPool
    private lateinit var soundPool: SoundPool
    // soundID
    private var oon = 0
    // soundID
    private var aon = 1

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
        this.soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(2)
            .build()
        this.oon = this.soundPool.load(this, R.raw.oon_48, 1)
        this.aon = this.soundPool.load(this, R.raw.aon_48, 1)

    }

    override fun onDestroy() {
        soundPool.release()
        super.onDestroy()
    }

    fun sayOon(view: View) {
        soundPool.play(oon, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun sayAon(view: View) {
        soundPool.play(aon, 1.0f, 1.0f, 0,0,1.0f)
    }

}