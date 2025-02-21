package com.asheeshk.uts.databse

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asheeshk.uts.ActivityStation
import com.asheeshk.uts.databse.ui.theme.ActivityLoginTheme
import com.asheeshk.uts.ui.theme.colorPrimary

class ActivityTableList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLoginTheme {
               MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    val tables = listOf("Users", "Orders", "Products", "Categories", "Transactions") // Example list
    val filteredTables = tables.filter { it.contains(searchQuery, ignoreCase = true) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "UTS Database")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        (context as ActivityTableList).finish()
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
    ){innerPadding->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search Table") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // Lazy Column List
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(filteredTables) { tableName ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp)
                                .clickable {
                                /* Handle click */
                                    val intent=Intent(context,ActivityTableColumn::class.java)
                                    context.startActivity(intent)
                                },
                            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
                        ) {
                            Row( modifier = Modifier.padding(16.dp)){
                                Text(
                                    text = tableName,
                                    fontSize = 18.sp,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(text = "20")
                            }

                        }
                    }
                }
            }

    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ActivityLoginTheme {
        MainScreen()

    }
}