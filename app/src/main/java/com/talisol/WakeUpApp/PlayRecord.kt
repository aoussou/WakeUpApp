package com.talisol.WakeUpApp

import WakeUpApp.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


class PlayRecord : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        var TAG = "test"
        Log.i(TAG, "broadcast")

        var mp = MediaPlayer.create(context, R.raw.originofspecies_01_darwin_128kb)

        mp.setVolume(1.0f,1.0f)
        mp.start()

    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
//
//        super.onCreate(savedInstanceState)
//        var mp = MediaPlayer.create(this, R.raw.originofspecies_01_darwin_128kb)
//
//        mp.setVolume(1.0f,1.0f)
//        mp.start()
//
//
//
//


//
//    }







//    }
}