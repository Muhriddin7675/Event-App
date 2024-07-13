package com.example.brodcasteventapp

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.provider.Settings
import android.util.Log
import com.example.brodcasteventapp.data.MyShared

class PowerConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        if (MyShared.getBatteryConnect()) {
            when (intentAction) {
                Intent.ACTION_POWER_DISCONNECTED -> {
                    playSound(context, R.raw.power_dicconnect)
                }

                Intent.ACTION_POWER_CONNECTED -> {
                    playSound(context, R.raw.power_connect)
                }
            }
        }
        if (MyShared.getScreenOnOff()) {
            when (intentAction) {
                Intent.ACTION_SCREEN_OFF -> {
                    playSound(context, R.raw.screen_off)
                }

                Intent.ACTION_SCREEN_ON -> {
                    playSound(context, R.raw.screen_on)
                }
            }
        }
        if (MyShared.getBluetoothOnOff()) {
            when (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)) {
                BluetoothAdapter.STATE_ON -> {
                    playSound(context, R.raw.blutuz_on)
                }

                BluetoothAdapter.STATE_OFF -> {
                    playSound(context, R.raw.blutus_off)
                }
            }
        }

        if (MyShared.getWifiOnOff()) {
            when (intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    playSound(context, R.raw.wifi_on)
                }

                WifiManager.WIFI_STATE_DISABLED -> {
                    playSound(context, R.raw.wifi_off)
                }
            }
        }

        when (intentAction) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isTurnedOn = Settings.Global.getInt(
                    context.contentResolver, Settings.Global.AIRPLANE_MODE_ON
                ) != 0

                if (isTurnedOn) {
                    playSound(context, R.raw.airpalan_on)
                } else {
                    playSound(context, R.raw.airpaln_of)
                }
            }

            ConnectivityManager.CONNECTIVITY_ACTION -> {
                val connectivityManager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork = connectivityManager.activeNetwork
                val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
                val hasInternet = networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true

                if (MyShared.getInternetOnOff()) {
                    if (hasInternet)
                        playSound(context, R.raw.internet_on)
                    else
                        playSound(context, R.raw.internet_iff)
                }
            }

            Intent.ACTION_LOCALE_CHANGED -> {
                if (MyShared.getHotspotOnOff()) {
                    playSound(context, R.raw.language_change)
                }
            }
        }
    }

    private fun playSound(context: Context, soundResId: Int) {
        val mediaPlayer = MediaPlayer.create(context, soundResId)
        mediaPlayer.start()
    }

    fun myLog(message: String) {
        Log.d("TTT", message)
    }
}
