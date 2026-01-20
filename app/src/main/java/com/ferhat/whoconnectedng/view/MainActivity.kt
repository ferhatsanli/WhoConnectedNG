package com.ferhat.whoconnectedng.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ferhat.whoconnectedng.ui.theme.WhoConnectedNGTheme
import com.ferhat.whoconnectedng.viewmodel.DeviceViewModel

class MainActivity : ComponentActivity() {

    val devViewModel: DeviceViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val devList = devViewModel.deviceList.value
        setContent {
            LaunchedEffect(Unit) {
                devViewModel.downloadDeviceData()
            }
            WhoConnectedNGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DeviceListView(
                        modifier = Modifier.padding(innerPadding),
                        devList = devViewModel.deviceList.value,
                        devViewModel
                    )
                }
            }
        }
    }
}
