package com.example.bmicalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalcapp.components.SetTextField
import com.example.bmicalcapp.ui.theme.BMICalcAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalcAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = "BMI計算アプリ",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        //身長
                        SetTextField(
                            value= viewModel.height,
                            onValueChange = {viewModel.height = it},
                            label ="身長(cm)",
                            placeholder = "170",
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        //体重
                        SetTextField(
                            value = viewModel.weight ,
                            onValueChange  = {viewModel.weight = it},
                            label = "体重(kg)",
                            placeholder = "60"
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        //計算
                        Button(
                            onClick = {viewModel.calcBMI()},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(Color.Red),
                        ) {
                            Text(
                                text = "計算!",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        //計算結果表示
                        Text(
                            text = "あなたのBMIは${viewModel.bmi}です",
                            modifier=Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.DarkGray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                }
            }
        }
    }
}

