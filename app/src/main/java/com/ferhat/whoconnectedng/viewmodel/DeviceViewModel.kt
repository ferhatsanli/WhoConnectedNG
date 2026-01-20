package com.ferhat.whoconnectedng.viewmodel

import android.content.ClipData
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.content.ClipboardManager
import androidx.compose.runtime.mutableStateMapOf
import com.ferhat.whoconnectedng.api.HomeApi
import com.ferhat.whoconnectedng.api.HomeService
import com.ferhat.whoconnectedng.api.MacVenApi
import com.ferhat.whoconnectedng.api.MacVenService
import com.ferhat.whoconnectedng.model.Device
import com.ferhat.whoconnectedng.model.MacData
import kotlinx.coroutines.delay

class DeviceViewModel: ViewModel() {
    private val homeApiService: HomeApi = HomeService.createService()
    private val macVenApiService: MacVenApi = MacVenService.createService()
    private val TAG = "FerhatLog"

    val deviceList = mutableStateOf<List<Device>>(emptyList())
    val deviceBrands = mutableStateMapOf<String,String?>()
    val successful = mutableStateOf<Boolean>(false)
    val error = mutableStateOf<Boolean>(false)

    fun downloadDeviceData() {
        successful.value = false
        getDevices()
        getBrandNames()
    }
    fun getDevices(){
        var retryCounter = 0
        viewModelScope.launch {
            while (!successful.value && retryCounter < 3)
                try {
                    Log.i(TAG, "getDevices: started | deviceList.size = ${deviceList.value.size}")
                    deviceList.value = homeApiService.getDevices()
                    Log.i(TAG, "getDevices: done | deviceList.size = ${deviceList.value.size}")
                    if (deviceList.value.size > 0){
                        successful.value = true
                        initBrandNames()
                        for (d in deviceList.value){
                            Log.i(TAG, "getDevices: $d")
                        }
                    }
                } catch (e: Exception){
                    Log.e(TAG, "getDevices: $e")
                    successful.value = false
                    retryCounter++
                    Log.e(TAG, "getDevices: $retryCounter.try unsuccessful", )
                    delay(500)
                }
            if (!successful.value && retryCounter > 3)
                error.value = true
        }
    }

    fun initBrandNames(){
        if (deviceList.value.size > 0)
            for (mac in (deviceList.value.map { it.mac })){
                deviceBrands[mac] = "Loading..."
            }
    }
    fun getBrandNames(){
        var retryCounter = 0
        viewModelScope.launch {
            while (deviceList.value.size == 0 && retryCounter < 6){
                retryCounter++
                delay(500)
            }
            val macList = deviceList.value.map { it.mac }
            Log.i(TAG, "getBrandNames: macList = $macList")

            val tokenData = homeApiService.getMVToken()
            Log.i(TAG, "getBrandNames: token = ${tokenData.token.substring(0..5)}...")

            for (mac in macList) {
                Log.i(TAG, "getBrandNames: mac = $mac")
                try{
                    val macData: MacData = macVenApiService.getMacData(mac, "Bearer ${tokenData.token}")
                    deviceBrands[mac] = macData.data.organizationName
                    Log.i(TAG, "getBrandNames: $mac -> ${deviceBrands[mac]}")
                } catch (e: Exception) {
                    Log.e(TAG, "getBrandNames: ${e.message}", )
                    deviceBrands[mac] = null
                }
                delay(1000)
            }
        }
    }
    fun copyToClipboard(context: Context, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.setPrimaryClip(clip)
    }
}