package com.asheeshk.uts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asheeshk.uts.ui.theme.ActivityLoginTheme
import com.asheeshk.uts.ui.theme.colorPrimary
import com.asheeshk.uts.ui.theme.colorPrimaryDark

class ActivityLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                {innerPadding->
                    val modifier=Modifier.padding(innerPadding)
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_app_logo),
                            contentDescription = "",
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .padding(horizontal = 10.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(0.dp)
                                    .wrapContentHeight(),
                                textAlign = TextAlign.Start,
                                text = "UTS",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                            )
                            Text(
                                modifier = Modifier
                                    .padding(0.dp)
                                    .wrapContentHeight(),
                                textAlign = TextAlign.Start,
                                text = "IR Unreserved Ticketing",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .background(Color.Red, shape = CircleShape)
                                .padding(5.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                },
                navigationIcon = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorPrimary,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "© 2024 My App",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        containerColor = Color.Gray
    ) { innerPadding ->
        LoginForm(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var mobileNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("PASSWORD") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "LOGIN WITH",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = colorPrimary
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {


            // Password Login
            Row(
                modifier = Modifier
                    .weight(1f)
                    .selectable(
                        selected = (selectedOption == "PASSWORD"),
                        onClick = { selectedOption = "PASSWORD" },
                        role = Role.RadioButton
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorPrimary,
                        unselectedColor = Color.Gray
                    ),
                    selected = (selectedOption == "PASSWORD"),
                    onClick = { selectedOption = "PASSWORD" }
                )
                Text(text = "Password".uppercase(), fontSize = 12.sp)
            }
            // Mobile Login
            Row(
                modifier = Modifier
                    .weight(1f)
                    .selectable(
                        selected = (selectedOption == "OTP"),
                        onClick = { selectedOption = "OTP" },
                        role = Role.RadioButton
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorPrimary,
                        unselectedColor = Color.Gray
                    ),
                    selected = (selectedOption == "OTP"),
                    onClick = { selectedOption = "OTP" }
                )
                Text(text = "OTP".uppercase(), fontSize = 12.sp)
            }
        }
        // based on the selected option, show the corresponding input fields

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = { Text("Mobile Number") },
                keyboardOptions=KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = Color.Gray,
                    focusedLabelColor = colorPrimary,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    cursorColor = colorPrimary,
                    focusedIndicatorColor = colorPrimaryDark,
                    unfocusedIndicatorColor = colorPrimary
                )
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth().background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = colorPrimary,
                    unfocusedLabelColor = Color.Gray,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    cursorColor = colorPrimary,
                    focusedIndicatorColor = colorPrimaryDark,
                    unfocusedIndicatorColor = colorPrimary
                )
            )

            Spacer(modifier = Modifier.height(24.dp))
            Button(modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally), onClick = { /* Handle login logic */ }) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Don't have an account? Sign Up",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

