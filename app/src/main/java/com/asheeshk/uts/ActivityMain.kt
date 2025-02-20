package com.asheeshk.uts

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.asheeshk.uts.ui.theme.colorRed
import kotlinx.coroutines.launch


class ActivityMain : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_app_logo),
                            contentDescription = "",
                            modifier = Modifier.size(70.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .padding(end = 10.dp)
                                .align(Alignment.CenterVertically)
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
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .padding(5.dp)
                                .align(Alignment.CenterVertically)
                        )

                        Text(
                            text = "Login".uppercase(),
                            color = Color.White,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.W700,
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(end = 10.dp)
                                .align(Alignment.CenterVertically)
                                .background(colorRed, shape = CircleShape)
                                .padding(horizontal = 2.dp, vertical = 0.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(end = 10.dp)
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
        bottomBar = {},
        floatingActionButton = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Help".uppercase(), modifier = Modifier.padding(end = 10.dp),
                    textAlign = TextAlign.Center
                )
                Icon(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.Red,
                                    Color.Yellow
                                )
                            ), shape = CircleShape
                        )
                        .padding(20.dp),
                    imageVector = Icons.Filled.Face, contentDescription = ""
                )
            }

        })
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // inner content here
            HorizontalPagerWithTabs()
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithTabs() {
    val ticketTypes = listOf(
        "Journey Ticket" to Icons.Filled.ThumbUp,
        "QR Booking" to Icons.Filled.Call,
        "Quick Booking" to Icons.Filled.Done,
        "Platform Ticket" to Icons.Filled.Face,
        "Season Ticket" to Icons.Filled.Lock
    )
    //val tabTitles =  listOf("Journey Ticket", "QR Booking", "Quick Booking", "Platform Ticket", "Season Ticket")
    val pagerState = rememberPagerState(0, 0f, pageCount = { ticketTypes.size })
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        // Tabs
        TabRow(
            containerColor = Color.White,
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = colorPrimary // Change Indicator Color Here
                )
            }
        ) {
            ticketTypes.forEachIndexed { index, tab ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.scrollToPage(index) }
                    },
                    text = {
                        Column {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(bottom = 5.dp)
                                    .background(
                                        colorPrimary, shape = CircleShape
                                    )
                                    .padding(5.dp),
                                imageVector = tab.second,
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                            Text(
                                tab.first,
                                maxLines = 2,
                                lineHeight = 11.sp,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                        }
                    }
                )
            }
        }

        // Horizontal Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFEEEEEE))
            ) {
                Column {
                    MainGridButtons()
                    when (page) {
                        0 -> {
                            NormalBooking()
                        }

                        1 -> {
                            QrBooking()
                        }

                        2 -> {
                            QuickBooking()
                        }

                        3 -> {
                            PlateFormBooking()
                        }

                        4 -> {
                            SeasonBooking()
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun MainGridButtons() {
    val menuItems = listOf(
        "Cancel Ticket" to Icons.Filled.LocationOn,
        "Booking History" to Icons.Filled.Refresh,
        "Show Ticket" to Icons.Filled.ShoppingCart,
        "R-Wallet" to Icons.Outlined.PlayArrow,
        "Profile" to Icons.Filled.AccountCircle,
        "Transaction" to Icons.Outlined.Settings
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 Columns
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.5.dp, end = 2.5.dp, start = 2.5.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        items(menuItems) { (title, icon) ->
            //GridItem(title, icon)
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .background(Color.White, shape = RectangleShape)
                    .shadow(0.1.dp)
                    .clickable { /* Handle Click */ },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = Color.Gray,
                    modifier = Modifier
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title.uppercase(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = colorPrimary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPagerWithTabs() {
    HorizontalPagerWithTabs()
}

// Complete this function
@Composable
fun NormalBooking() {
    var selectedOption by remember { mutableStateOf("") }
    var sourceStation by remember { mutableStateOf("New Delhi") }
    var destinationStation by remember { mutableStateOf("Kanpur Central") }
    val context= LocalContext.current

    // Register Activity Result Launcher
    val stationLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedStation = result.data?.getStringExtra("station")
            val type = result.data?.getIntExtra("type",0)
            selectedStation?.let {
                Toast.makeText(context, "Selected Station: $it", Toast.LENGTH_SHORT).show()
                if(type==0){
                    sourceStation=it
                }else{
                    destinationStation=it
                }
                // Handle the selected station (e.g., update state or save)
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = "Normal Booking".uppercase(),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow
                            )
                        )
                    )
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier.background(
                    Color.White,
                    shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
                )
            ) {
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
                                selected = (selectedOption == "Book & Travel(Paperless)"),
                                onClick = { selectedOption = "Book & Travel(Paperless)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Travel(Paperless)"),
                            onClick = { selectedOption = "Book & Travel(Paperless)" }
                        )
                        Text(text = "Book & Travel (Paperless)", fontSize = 10.sp)
                    }
                    // Mobile Login
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .selectable(
                                selected = (selectedOption == "Book & Print(Paper)"),
                                onClick = { selectedOption = "Book & Print(Paper)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Print(Paper)"),
                            onClick = { selectedOption = "Book & Print(Paper)" }
                        )
                        Text(text = "Book & Print (Paper)", fontSize = 10.sp)
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .background(Color.White, shape = RoundedCornerShape(5.dp))
                        .clip(RoundedCornerShape(5.dp))
                        .shadow(elevation = 0.5.dp)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "* Use this option if you are outside station permises/Railway track.",
                        color = Color.Black,
                        fontSize = 8.sp,
                        lineHeight = 12.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "* Use show ticket option on mobile is the travel authority.",
                        color = Color.Black,
                        fontSize = 8.sp,
                        lineHeight = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "* Set your phone GPS to high accuracy mode.",
                        color = Color.Black,
                        fontSize = 8.sp,
                        lineHeight = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                    Text(
                        text = "* No cancellation is allowed for paperless ticket.",
                        color = colorPrimaryDark,
                        fontSize = 8.sp,
                        lineHeight = 12.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                // Source and destination
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    // Source of Station
                    Row(modifier = Modifier.weight(1f)) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
                                .clickable {
                                    val intent=Intent(context,ActivityStation::class.java).apply {
                                        putExtra("type",0)
                                    }
                                    stationLauncher.launch(intent)
                                }
                        ) {
                            Text(
                                text = "Depart From ",
                                color = Color.Black,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "NDLS",
                                color = Color.Black,
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight.W400,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = sourceStation,
                                color = Color.Black,
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            )
                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    start = 20.dp,
                                    end = 20.dp
                                ), color = colorPrimary
                            )


                        }
                    }
                    // Arrow of Switch
                    Column(
                        modifier = Modifier
                            .width(50.dp)
                            .padding(top = 30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            modifier = Modifier.size(width = 50.dp, height = 20.dp),
                            tint = Color.Black,
                            contentDescription = ""
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            modifier = Modifier.size(width = 50.dp, height = 20.dp),
                            tint = Color.Black,
                            contentDescription = ""
                        )
                    }
                    // Destination of Station
                    Row(modifier = Modifier
                        .weight(1f)
                        .clickable {
                            val intent=Intent(context,ActivityStation::class.java).apply {
                                putExtra("type",1)
                            }
                            stationLauncher.launch(intent)
                        }) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Going To ",
                                color = Color.Black,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "CNB",
                                color = Color.Black,
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight.W400,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)

                            )
                            Text(
                                text = destinationStation,
                                color = Color.Black,
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)

                            )
                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    start = 20.dp,
                                    end = 20.dp
                                ), color = colorPrimary
                            )

                        }

                    }
                }

                Row(modifier = Modifier.padding(20.dp)) {

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color.Red,
                                        Color.Yellow
                                    )
                                ), shape = RoundedCornerShape(20.dp)
                            )
                            .padding(5.dp),
                        text = "next Trains".uppercase(),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color.Red,
                                        Color.Yellow
                                    )
                                ), shape = RoundedCornerShape(20.dp)
                            )
                            .padding(5.dp),
                        text = "Get Fare".uppercase(),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color = Color.White
                    )

                }

            }

        }
    }

}

// complete this function
@Composable
fun QrBooking() {
    var selectedOption by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = "QR Booking".uppercase(),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow
                            )
                        )
                    )
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
                    )
                    .padding(bottom = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val textList = listOf(
                    "journey ticket by qr",
                    "platform ticket by qr",
                    "superfast surcharge by qr"
                )
                textList.forEach { text ->
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .width(IntrinsicSize.Max)  // Ensures all text items take the max width of the largest one
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color.Red, Color.Yellow)
                                ),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 20.dp, vertical = 5.dp),
                        text = text.uppercase(),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }

            }

        }
    }
}

@Composable
fun QuickBooking() {
    var selectedOption by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = "Quick Booking".uppercase(),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow
                            )
                        )
                    )
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier.background(
                    Color.White,
                    shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
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
                                selected = (selectedOption == "Book & Travel(Paperless)"),
                                onClick = { selectedOption = "Book & Travel(Paperless)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Travel(Paperless)"),
                            onClick = { selectedOption = "Book & Travel(Paperless)" }
                        )
                        Text(text = "Book & Travel (Paperless)", fontSize = 10.sp)
                    }
                    // Mobile Login
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .selectable(
                                selected = (selectedOption == "Book & Print(Paper)"),
                                onClick = { selectedOption = "Book & Print(Paper)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Print(Paper)"),
                            onClick = { selectedOption = "Book & Print(Paper)" }
                        )
                        Text(text = "Book & Print (Paper)", fontSize = 10.sp)
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .wrapContentWidth()  // Ensures all text items take the max width of the largest one
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Red, Color.Yellow)
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 40.dp, vertical = 5.dp),
                    text = "next".uppercase(),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = Color.White
                )

            }

        }
    }
}

@Composable
fun PlateFormBooking() {
    var selectedOption by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = "PlateForm Booking".uppercase(),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow
                            )
                        )
                    )
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier.background(
                    Color.White,
                    shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
                )
            ) {
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
                                selected = (selectedOption == "Book & Travel(Paperless)"),
                                onClick = { selectedOption = "Book & Travel(Paperless)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Travel(Paperless)"),
                            onClick = { selectedOption = "Book & Travel(Paperless)" }
                        )
                        Text(text = "Book & Travel (Paperless)", fontSize = 10.sp)
                    }
                    // Mobile Login
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .selectable(
                                selected = (selectedOption == "Book & Print(Paper)"),
                                onClick = { selectedOption = "Book & Print(Paper)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Print(Paper)"),
                            onClick = { selectedOption = "Book & Print(Paper)" }
                        )
                        Text(text = "Book & Print (Paper)", fontSize = 10.sp)
                    }
                }
                //  Add Station Detail (Name/Code person and payment type)

                Text(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .wrapContentWidth()  // Ensures all text items take the max width of the largest one
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Red, Color.Yellow)
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 40.dp, vertical = 5.dp),
                    text = "next".uppercase(),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = Color.White
                )

            }

        }
    }
}

@Composable
fun SeasonBooking() {
    var selectedOption by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = "Season Booking".uppercase(),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow
                            )
                        )
                    )
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier.background(
                    Color.White,
                    shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
                )
            ) {
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
                                selected = (selectedOption == "Book & Travel(Paperless)"),
                                onClick = { selectedOption = "Book & Travel(Paperless)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Travel(Paperless)"),
                            onClick = { selectedOption = "Book & Travel(Paperless)" }
                        )
                        Text(text = "Book & Travel (Paperless)", fontSize = 10.sp)
                    }
                    // Mobile Login
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .selectable(
                                selected = (selectedOption == "Book & Print(Paper)"),
                                onClick = { selectedOption = "Book & Print(Paper)" },
                                role = Role.RadioButton
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorPrimary,
                                unselectedColor = Color.Gray
                            ),
                            selected = (selectedOption == "Book & Print(Paper)"),
                            onClick = { selectedOption = "Book & Print(Paper)" }
                        )
                        Text(text = "Book & Print (Paper)", fontSize = 10.sp)
                    }
                }

            }

        }
    }
}

