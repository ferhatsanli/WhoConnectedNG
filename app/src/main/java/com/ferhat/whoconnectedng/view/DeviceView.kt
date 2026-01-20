package com.ferhat.whoconnectedng.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ferhat.whoconnectedng.model.Device
import com.ferhat.whoconnectedng.viewmodel.DeviceViewModel

@Composable
fun DeviceView(device: Device, viewModel: DeviceViewModel){
    val context = LocalContext.current
    val brandName = viewModel.deviceBrands[device.mac]
    Card(modifier = Modifier.padding(8.dp).height(IntrinsicSize.Min)) {
        Column() {
            //name
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(device.name)
                    brandName?.let {
                        Text(text = brandName)
                    }
                }

            }
            //ip|mac
            Row(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { viewModel.copyToClipboard(context, device.ip)}) { Text(device.ip) }
                VerticalDivider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = DividerDefaults.Thickness + 2.dp
                )
                Button(onClick = { viewModel.copyToClipboard(context, device.mac)}) { Text(device.mac) }
            }
            // time
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(device.time)
            }
        }
    }
}