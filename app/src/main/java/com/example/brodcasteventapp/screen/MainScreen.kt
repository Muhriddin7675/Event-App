package com.example.brodcasteventapp.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.brodcasteventapp.R
import com.example.brodcasteventapp.data.MyShared
import com.example.brodcasteventapp.databinding.ScreenMainBinding

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        load()
        powerConnectInDisconnected()
        screenOnOff()
        bluetoothOnOff()
        wifiOnOff()
        airplane()
        internet()
        hotspot()

        binding.btnInfo.setOnClickListener {
            findNavController().navigate(MainScreenDirections.actionMainScreen2ToInfoScreen())
        }
    }

    private fun load() {
        setButtonOnOff(binding.powerConnectDisconnect, MyShared.getBatteryConnect())
        setButtonOnOff(binding.screenOnOff, MyShared.getScreenOnOff())
        setButtonOnOff(binding.bluetoothOnOff, MyShared.getBluetoothOnOff())
        setButtonOnOff(binding.btnWifi, MyShared.getWifiOnOff())
        setButtonOnOff(binding.btnAirplane, MyShared.getAirplaneOnOff())
        setButtonOnOff(binding.btnInternet, MyShared.getInternetOnOff())
        setButtonOnOff(binding.btnHotspot, MyShared.getHotspotOnOff())
    }

    private fun setButtonOnOff(button: ImageView, bool: Boolean) {
        if (bool) {
            button.setImageResource(R.drawable.ic_btn_on)
        } else {
            button.setImageResource(R.drawable.ic_btn_off)
        }
    }

    private fun powerConnectInDisconnected() {
        val button = binding.powerConnectDisconnect

        button.setOnClickListener {
            if (MyShared.getBatteryConnect()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setBatteryConnect(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setBatteryConnect(true)
            }
        }
    }

    private fun screenOnOff() {
        val button = binding.screenOnOff
        button.setOnClickListener {
            if (MyShared.getScreenOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setScreenOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setScreenOnOff(true)
            }
        }
    }

    private fun bluetoothOnOff() {
        val button = binding.bluetoothOnOff
        button.setOnClickListener {
            if (MyShared.getBluetoothOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setBluetoothOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setBluetoothOnOff(true)
            }
        }
    }

    private fun wifiOnOff() {
        val button = binding.btnWifi
        button.setOnClickListener {
            if (MyShared.getWifiOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setWifiOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setWifiOnOff(true)
            }
        }
    }

    private fun airplane() {
        val button = binding.btnAirplane
        button.setOnClickListener {
            if (MyShared.getAirplaneOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setAirplaneOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setAirplaneOnOff(true)
            }
        }
    }

    private fun internet() {
        val button = binding.btnInternet
        button.setOnClickListener {
            if (MyShared.getInternetOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setInternetOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setInternetOnOff(true)
            }
        }
    }

    private fun hotspot() {
        val button = binding.btnHotspot
        button.setOnClickListener {
            if (MyShared.getHotspotOnOff()) {
                button.setImageResource(R.drawable.ic_btn_off)
                MyShared.setHotspotOnOff(false)
            } else {
                button.setImageResource(R.drawable.ic_btn_on)
                MyShared.setHotspotOnOff(true)
            }
        }
    }
}