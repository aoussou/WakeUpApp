package com.talisol.WakeUpApp

import WakeUpApp.R
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class PlayRecord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mp = MediaPlayer.create(this, R.raw.originofspecies_01_darwin_128kb)

        mp.setVolume(1.0f,1.0f)
        mp.start()







    }
}