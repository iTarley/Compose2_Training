package com.example.compose2

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose2.ui.theme.Compose2Theme
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF585BA8)
    ) {
        Column(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            CreateCircle()
        }
    }
    
}





@OptIn(ExperimentalFoundationApi::class)
@Composable


fun CreateCircle(){
    var number by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    Column(horizontalAlignment = CenterHorizontally) {
        Text(text = "$number", fontSize = 100.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(120.dp))

    }

    val activity = (LocalContext.current as? Activity)
    if (number < 0){
        for (i in 1..1){
            Toast.makeText(context, "YOU LOSE \uD83D\uDE08", Toast.LENGTH_LONG).show()
            activity?.finish()
        }
    }

    val handler = Handler()
    handler.postDelayed({
        number -= 1
    }, 1000)

    Card(modifier = Modifier
        .padding(3.dp)
        .clickable {
            number += 3
        }
        .size(100.dp),
        shape = CircleShape) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose2Theme {
        MyApp()
    }
}