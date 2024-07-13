package com.example.brodcasteventapp

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.ImageView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.brodcasteventapp.data.MyShared
import com.example.brodcasteventapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS), Context.RECEIVER_NOT_EXPORTED
            )
        } else {
            val intent = Intent(this, MyService::class.java)
            if (Build.VERSION.SDK_INT >= 26) {
                this.startForegroundService(intent)
            } else this.startService(intent)
        }
        Intent().also { intent ->
            intent.setAction("com.example.broadcast.MY_NOTIFICATION")
            intent.putExtra("data", "Nothing to see here, move along.")
            sendBroadcast(intent)
        }
    }


}