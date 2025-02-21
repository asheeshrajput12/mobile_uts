package com.asheeshk.uts.databse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asheeshk.uts.databse.ui.theme.ActivityLoginTheme
import com.asheeshk.uts.ui.theme.colorPrimary

class ActivityTableColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLoginTheme {
                ColumnScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScreen() {
    val context = LocalContext.current

    // Sample column names & data (Replace with real database data)
    val columnNames = listOf("ID", "Name", "Location", "Code", "Status", "Type", "Created At")
    val tableData = List(50) { index ->
        listOf("$index", "Station $index", "City $index", "Code$index", "Active", "Metro", "2024-02-22")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "tbl_station") },
                navigationIcon = {
                    IconButton(onClick = { (context as? ActivityTableColumn)?.finish() }) {
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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Enable Horizontal Scrolling for the Whole Table
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Sticky Header for Column Names
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Gray)
                                .padding(8.dp)
                        ) {
                            columnNames.forEach { column ->
                                Text(
                                    text = column,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier
                                        .width(120.dp) // Ensure each column has a fixed width
                                        .padding(4.dp)
                                )
                            }
                        }
                    }

                    // Data Rows
                    items(tableData) { rowData ->
                        TableRow(rowData)
                    }
                }
            }
        }
    }
}

// Row Composable for Table Entries
@Composable
fun TableRow(rowData: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        rowData.forEach { cell ->
            Text(
                text = cell,
                fontSize = 14.sp,
                modifier = Modifier
                    .width(120.dp) // Ensure consistent width for each cell
                    .padding(4.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ActivityLoginTheme {
        ColumnScreen()
    }
}