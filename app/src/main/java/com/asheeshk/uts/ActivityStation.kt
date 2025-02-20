package com.asheeshk.uts

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asheeshk.uts.ui.theme.ActivityLoginTheme
import com.asheeshk.uts.ui.theme.colorPrimary

class ActivityStation : ComponentActivity() {
    var type = 0
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent?.let {
            type = it.getIntExtra("type", 0)
        }
        enableEdgeToEdge()
        setContent {
            ActivityLoginTheme {
                Greeting(type)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(type: Int) {
    val context= LocalContext.current
    val sampleStations = listOf(
        "New Delhi (NDLS)",
        "Mumbai CST (CSTM)",
        "Howrah Junction (HWH)",
        "Chennai Central (MAS)",
        "Kolkata (KOAA)",
        "Bangalore City (SBC)",
        "Secunderabad Junction (SC)",
        "Ahmedabad Junction (ADI)",
        "Pune Junction (PUNE)",
        "Bhopal Junction (BPL)",
        "Patna Junction (PNBE)",
        "Lucknow Charbagh (LKO)",
        "Jaipur Junction (JP)",
        "Guwahati (GHY)",
        "Ernakulam Junction (ERS)",
        "Visakhapatnam Junction (VSKP)",
        "Coimbatore Junction (CBE)",
        "Nagpur Junction (NGP)",
        "Chandigarh (CDG)",
        "Varanasi Junction (BSB)"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = if (type == 0) "Enter Source Station" else "Enter Destination Station")
                },
                navigationIcon = {

                    IconButton(onClick = {
                        (context as ActivityStation).finish()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorPrimary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color.White, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
                    .shadow(1.dp)
                    .padding(10.dp)
            ) {
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        color = colorPrimary,
                        text = "Enter Station Name/Code"
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        value = "",
                        onValueChange = {},
                        leadingIcon = {},
                        maxLines = 1
                    )
                    // Lazy Column for displaying the list of station
                    LazyColumn(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(0.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        items(sampleStations) { station ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(2.dp),
                                colors = CardColors(
                                    contentColor = Color.Black,
                                    containerColor = Color.White,
                                    disabledContentColor = Color.White,
                                    disabledContainerColor = Color.White
                                ),
                                elevation = CardDefaults.cardElevation(2.dp),
                                onClick = {
                                    // Return station data to previous activity
                                    val intent = Intent()
                                    intent.putExtra("station", station)
                                    intent.putExtra("type",type)
                                    intent.putExtra("station_id", station)
                                    (context as? ComponentActivity)?.setResult(RESULT_OK, intent)
                                    (context as? ComponentActivity)?.finish()
                                }
                            ) {
                                Text(
                                    text = station.uppercase(),
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(10.dp),
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivityLoginTheme {
        Greeting(1)
    }
}