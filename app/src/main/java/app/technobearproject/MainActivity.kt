package app.technobearproject

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.technobearproject.ui.theme.TechnoBearProjectTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechnoBearProjectTheme {
                MakeScaffold()
            }
        }
    }
}

@Composable
fun MakeScaffold() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                            if (scaffoldState.drawerState.isClosed) {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                            else {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                    } ) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                title = {
                    Text(text = "TechnoBear")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "like")
                    }
                },
                backgroundColor = MaterialTheme.colors.primarySurface
            )
        },
        drawerContent = {
            MenuContent()
        }
    ) {
        InitialInformation()
    }
}

@Composable
@Preview(name = "LightScaffoldPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkScaffoldPreview"
)
fun MakeScaffoldPreview() {
    TechnoBearProjectTheme {
        MakeScaffold()
    }
}

@Composable
fun MenuContent() {
    Column(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "TechnoBear Menu",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 48.sp)
        }
        Row(modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.AccountBox,
                contentDescription = stringResource(id = R.string.menu_name),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Account",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 24.sp)
        }
        Row(modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.catalog),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Catalog",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 24.sp)
        }
        Row(modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.ShoppingCart,
                contentDescription = stringResource(id = R.string.basket),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Basket",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 24.sp)
        }
        Row(modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Info,
                contentDescription = stringResource(id = R.string.about_company),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "About Company",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 24.sp)
        }
        Row(modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Email,
                contentDescription = stringResource(id = R.string.faq),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "FAQ",
                modifier = Modifier.padding(all = 8.dp),
                fontSize = 24.sp)
        }
    }
}

@Composable
@Preview(name = "LightMenuContentPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkMenuContentPreview"
)
fun MenuContentPreview() {
    TechnoBearProjectTheme {
        MenuContent()
    }
}

@Composable
fun InitialInformation() {
    Column(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to TechnoBear shop!",
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 48.sp)
        Text(text = "Let's start shopping by opening application menu.",
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 24.sp)
        Text(text = "Just swipe from left to right to open the menu or click the menu button in the upper left corner.",
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 24.sp)
    }
}

@Composable
@Preview(name = "LightInitialInformationPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkInitialInformationPreview"
)
fun InitialInformationPreview() {
    TechnoBearProjectTheme {
        InitialInformation()
    }
}
