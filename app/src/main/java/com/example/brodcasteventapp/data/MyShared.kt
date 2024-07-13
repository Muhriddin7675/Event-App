package com.example.brodcasteventapp.data

import android.content.Context
import android.content.SharedPreferences

object MyShared {

    private lateinit var pref: SharedPreferences
    fun init(context: Context) {
        pref = context.getSharedPreferences("myShared", Context.MODE_PRIVATE)
    }

    fun setBatteryConnect(bool: Boolean) {
        pref.edit().putBoolean("POWER", bool).apply()
    }

    fun getBatteryConnect(): Boolean =
        pref.getBoolean("POWER", false)

    fun setScreenOnOff(bool: Boolean) {
        pref.edit().putBoolean("SCREEN", bool).apply()
    }

    fun getScreenOnOff(): Boolean =
        pref.getBoolean("SCREEN", false)

    fun setBluetoothOnOff(bool: Boolean) {
        pref.edit().putBoolean("Bluetooth", bool).apply()
    }

    fun getBluetoothOnOff(): Boolean =
        pref.getBoolean("Bluetooth", false)

    fun setAirplaneOnOff(bool: Boolean) {
        pref.edit().putBoolean("Airplane", bool).apply()
    }

    fun getAirplaneOnOff(): Boolean =
        pref.getBoolean("Airplane", false)

    fun setWifiOnOff(bool: Boolean) {
        pref.edit().putBoolean("Wifi", bool).apply()
    }

    fun getWifiOnOff(): Boolean =
        pref.getBoolean("Wifi", false)


    fun setInternetOnOff(bool: Boolean) {
        pref.edit().putBoolean("Internet", bool).apply()
    }

    fun getInternetOnOff(): Boolean =
        pref.getBoolean("Internet", false)

    fun setHotspotOnOff(bool: Boolean) {
        pref.edit().putBoolean("Hotspot", bool).apply()
    }

    fun getHotspotOnOff(): Boolean =
        pref.getBoolean("Hotspot", false)

}