package com.talisol.WakeUpApp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var picker: MaterialTimePicker
    private lateinit var alarmManager: AlarmManager
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, PlayRecord::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager




        setContent {
            var hour by remember { mutableStateOf("00") }
            var minute by remember { mutableStateOf("00") }

            val activity = LocalContext.current as AppCompatActivity

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = hour,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    text = minute,
                    modifier = Modifier
                        .fillMaxWidth()
                )


                Button(onClick = {
                    val picker = MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .build()
                    activity.let {
                        picker.show(it.supportFragmentManager, picker.toString())
                        picker.addOnPositiveButtonClickListener {
                            calendar = Calendar.getInstance()
                            calendar[Calendar.HOUR_OF_DAY] = picker.hour
                            calendar[Calendar.MINUTE] = picker.minute
                            calendar[Calendar.SECOND] = 0
                            calendar[Calendar.MILLISECOND] = 0
                            hour = picker.hour.toString()
                            minute = picker.minute.toString()



//                            alarmManager.setInexactRepeating(
                            alarmManager.setAndAllowWhileIdle(
                                AlarmManager.RTC_WAKEUP,
                                calendar.timeInMillis,
                                pendingIntent
                            )

                        }
                    }
                }) {
                    Text("Picker")

                }

                Button(onClick = {
                    var TAG = "test"
                    Log.i(TAG, "before broadcast")
//                    activity.startActivity(Intent(activity, PlayRecord::class.java))
                    activity.sendBroadcast(intent)
                }) {
                    Text(text = "Show List")
                }


            }
        }
    }
}
