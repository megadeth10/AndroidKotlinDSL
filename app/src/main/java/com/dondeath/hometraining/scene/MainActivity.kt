package com.dondeath.hometraining.scene

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dondeath.hometraining.Aaa
import com.dondeath.hometraining.theme.HomeTrainingColor
import com.dondeath.hometraining.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                this.setContent {
                    MainCompose()
                }
            }
        )
        Log.e(MainActivity::class.java.simpleName, "onCreate() build type: ${Aaa().b()}")
    }

    override fun onResume() {
        super.onResume()
        viewModel.setText("onResume")
        Log.e(MainActivity::class.java.simpleName, "onResume()")
    }
}

@Composable
private fun MainCompose() {
    val viewModel = makeViewModel()
    val text = viewModel.text
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeTrainingColor.PrimaryColor)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "build type: ${Aaa().b()}")
            Text(text = text.value)
            TextButton(onClick = { viewModel.setText("button") }) {
                Text(text = "set button")
            }
        }
    }
}

@Composable
fun makeViewModel(): MainViewModel {
    return if(LocalInspectionMode.current) {
        MainViewModel()
    } else {
        viewModel<MainViewModel>()
    }
}