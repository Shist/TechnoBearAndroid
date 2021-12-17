package app.technobearproject

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.technobearproject.ui.theme.TechnoBearProjectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class MenuPage {
    START_PAGE,
    ACCOUNT,
    CATALOG,
    BASKET,
    ABOUT_COMPANY,
    FAQ
}

const val ABOUT_COMPANY = "TechnoBear is a team of four developers, each of whom actively " +
        "contributes to the development and promotion of the project. In this application, " +
        "you have the opportunity to make a purchase of various digital equipment using the " +
        "interface that we have developed for you. Here is our team:\n" +
        "1) Alexey Kokhovets - head of the project\n" +
        "2) Andrey Grishkin - web component developer\n" +
        "3) Pavel Zhukovsky - mobile application developer\n" +
        "4) Fedor Miron - project tester and responsible for the API"

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
    val menuPage = remember { mutableStateOf(MenuPage.START_PAGE) }
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
                    // Here we can add some extra button for Toolbar in future
                },
                backgroundColor = MaterialTheme.colors.primarySurface
            )
        },
        drawerContent = {
            MenuContent(scaffoldState, scope, menuPage)
        }
    ) {
        when (menuPage.value) {
            MenuPage.START_PAGE -> {
                InitialInformation()
            }
            MenuPage.ACCOUNT -> {
                Text("Here will be account")
            }
            MenuPage.CATALOG -> {
                Text("Here will be catalog")
            }
            MenuPage.BASKET -> {
                Text("Here will be basket")
            }
            MenuPage.ABOUT_COMPANY -> {
                AboutCompany()
            }
            MenuPage.FAQ -> {
                FAQ(FAQ.qList)
            }
        }
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
fun MenuContent(scaffoldState: ScaffoldState,
                scope: CoroutineScope,
                menuPage: MutableState<MenuPage>) {
    Column(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "TechnoBear Menu",
                fontSize = 48.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clickable {
                    menuPage.value = MenuPage.ACCOUNT
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                } ) {
            Icon(imageVector = Icons.Default.AccountBox,
                contentDescription = stringResource(id = R.string.menu_name),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Account",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clickable {
                    menuPage.value = MenuPage.CATALOG
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                } ) {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.catalog),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Catalog",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clickable {
                    menuPage.value = MenuPage.BASKET
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                } ) {
            Icon(imageVector = Icons.Default.ShoppingCart,
                contentDescription = stringResource(id = R.string.basket),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "Basket",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clickable {
                    menuPage.value = MenuPage.ABOUT_COMPANY
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                } ) {
            Icon(imageVector = Icons.Default.Info,
                contentDescription = stringResource(id = R.string.about_company),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "About Company",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clickable {
                    menuPage.value = MenuPage.FAQ
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                } ) {
            Icon(imageVector = Icons.Default.Email,
                contentDescription = stringResource(id = R.string.faq),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .defaultMinSize(48.dp, 48.dp))
            Text(text = "FAQ",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 8.dp))
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
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val menuPage = remember { mutableStateOf(MenuPage.START_PAGE) }
        MenuContent(scaffoldState, scope, menuPage)
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
            fontSize = 48.sp,
            textAlign = TextAlign.Center)
        Text(text = "Let's start shopping by opening application menu.",
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 28.sp,
            textAlign = TextAlign.Center)
        Text(text = "Just swipe from left to right or click the menu button in the upper left corner.",
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 28.sp,
            textAlign = TextAlign.Center)
        Icon(modifier = Modifier
            .padding(all = 8.dp)
            .defaultMinSize(64.dp, 64.dp),
            imageVector = Icons.Default.ArrowForward,
            contentDescription = stringResource(id = R.string.swipe_hint_image))
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

@Composable
fun AboutCompany() {
    Column {
        Text(text = stringResource(R.string.about_TechnoBear),
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 48.sp,
            textAlign = TextAlign.Center)
        Text(text = ABOUT_COMPANY,
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Start)
    }
}

@Composable
@Preview(name = "LightAboutCompanyPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkAboutCompanyPreview"
)
fun AboutCompanyPreview() {
    TechnoBearProjectTheme {
        AboutCompany()
    }
}

@Composable
fun FAQ(questions: List<FAQ.Question>) {
    Column {
        Text(text = stringResource(R.string.faq),
            modifier = Modifier.padding(all = 8.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)),
            fontSize = 48.sp,
            textAlign = TextAlign.Center)
        LazyColumn {
            items(questions) { q ->
                QuestionCard(question = q.question, answer = q.answer)
            }
        }
    }
}

@Composable
@Preview(name = "LightFAQPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkFAQPreview"
)
fun FAQPreview() {
    TechnoBearProjectTheme {
        FAQ(FAQ.qList)
    }
}

@Composable
fun QuestionCard(question: String, answer: String) {
    Row (Modifier.padding(8.dp)) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Icon(imageVector = Icons.Default.Info,
                contentDescription = "question",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.surface else
                    MaterialTheme.colors.surface.copy(alpha = 0.1f),
            )

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = question,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    // surfaceColor color will be changing gradually from primary to surface
                    color = surfaceColor,
                    // animateContentSize will change the Surface size gradually
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = answer,
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

}

@Preview(name = "LightQuestionCardPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkQuestionCardPreview"
)
@Composable
fun QuestionCardPreview() {
    TechnoBearProjectTheme {
        QuestionCard("Some question", "Some answer")
    }
}