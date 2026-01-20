package com.ferhat.whoconnectedng.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ferhat.whoconnectedng.model.Device
import com.ferhat.whoconnectedng.viewmodel.DeviceViewModel

@Composable
fun DeviceListView(modifier: Modifier = Modifier, devList: List<Device>, viewModel: DeviceViewModel){
    val TAG = "FerhatLog"
    Log.i(TAG, "DeviceListView: parameter devList -> $devList")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (viewModel.successful.value){
            LazyColumn(modifier = modifier.weight(1f).fillMaxSize()) {
                items(devList) {
                    Log.i(TAG, "DeviceListView: it -> $it")
                    DeviceView(it, viewModel)
                }
            }
        }
        else if (!viewModel.successful.value && !viewModel.error.value) {
            CircularProgressIndicator()
        }
        else if (viewModel.error.value){
            Text(text = "Error!", fontSize = 36.sp)
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                viewModel.downloadDeviceData()
            }) { Text("Refresh") }
        }
    }
}