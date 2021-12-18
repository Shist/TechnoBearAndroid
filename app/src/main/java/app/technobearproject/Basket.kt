package app.technobearproject

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.technobearproject.ui.theme.TechnoBearProjectTheme

enum class BasketState {
    BASKET,
    CHECKOUT_ORDER,
    DELIVERY_DETAILS
}

@Composable
fun Basket(basketState: MutableState<BasketState>) {
    var search by rememberSaveable { mutableStateOf("") }
    val basketList = itemsWholeList.filter { it.basketAmount.value.toInt() > 0 }
    Column {
        Text(text = stringResource(R.string.basket),
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            fontSize = 36.sp,
            textAlign = TextAlign.Center)
        if (basketList.isNotEmpty()) {
            TextField(
                value = search,
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                onValueChange = {
                    search = it
                },
                label = {
                    Row {
                        Text("Search")
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "search",
                            modifier = Modifier
                                .padding(start = 8.dp))
                    }
                },
                maxLines = 1
            )
            LazyColumn {
                val searchedList = basketList.filter { it.name.contains(search) }
                if (searchedList.isEmpty()) {
                    item {
                        Text(text = stringResource(id = R.string.no_items_found),
                            modifier = Modifier.padding(all = 8.dp),
                            fontSize = 48.sp,
                            textAlign = TextAlign.Center)
                    }
                } else {
                    items(searchedList) { i ->
                        BasketItemCard(item = i)
                    }
                }
            }
        } else {
            Text(text = stringResource(id = R.string.basket_is_empty),
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 48.sp,
            textAlign = TextAlign.Center)
        }
    }
}

@Composable
@Preview(name = "LightBasketPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkBasketPreview"
)
fun BasketPreview() {
    val basketState = remember { mutableStateOf(BasketState.BASKET) }
    TechnoBearProjectTheme {
        Basket(basketState)
    }
}

@Composable
fun BasketItemCard(item: ProductItem) {
    val oneItemPrice = item.price.substring(1).toFloat()
    val itemsAmount = item.basketAmount.value.toInt()
    val wholeItemsPrice = "\$${(oneItemPrice * itemsAmount)}"
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(item.image),
            contentDescription = "item image",
            modifier = Modifier
                .padding(all = 8.dp))
        Column {
            Row {
                Text(
                    text = item.name,
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth(0.8f)
                )
                Icon(imageVector = Icons.Filled.Close,
                    contentDescription = "delete good from basket",
                    modifier = Modifier.size(40.dp).clickable {
                        item.basketAmount.value = "0"
                    })
            }
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.amount),
                        modifier = Modifier
                            .padding(all = 8.dp),
                    )
                    TextField(
                        value = item.basketAmount.value,
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .fillMaxWidth(0.3f),
                        onValueChange = {
                            item.basketAmount.value = it
                        },
                        label = { stringResource(id = R.string.amount) },
                        singleLine = true,
                        readOnly = true
                    )
                    Column {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "more products",
                            modifier = Modifier
                                .padding(all = 8.dp)
                                .clickable {
                                    var temp = item.basketAmount.value.toInt()
                                    temp += 1
                                    item.basketAmount.value = temp.toString()
                                })
                        Icon(imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "less products",
                            modifier = Modifier
                                .padding(all = 8.dp)
                                .clickable {
                                    var temp = item.basketAmount.value.toInt()
                                    temp -= 1
                                    if (temp < 0) temp = 0
                                    item.basketAmount.value = temp.toString()
                                })
                    }
                }
                Text(
                    text = wholeItemsPrice,
                    modifier = Modifier
                        .padding(all = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(name = "LightBasketItemCardPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkBasketItemCardPreview"
)
@Composable
fun BasketItemCardPreview() {
    val itemAmount = remember { mutableStateOf("1") }
    val currItem = remember { mutableStateOf(ProductItem("Name",
        "$100.00",
        R.drawable.qe43q60aauxru_samsung_607d5ce61da8f,
        "Description",
        ProductType.PHONE,
        itemAmount)) }
    TechnoBearProjectTheme {
        BasketItemCard(currItem.value)
    }
}

@Composable
fun CheckoutOrder(basketState: MutableState<BasketState>) {

}

@Composable
@Preview(name = "LightCheckoutOrderPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkCheckoutOrderPreview"
)
fun CheckoutOrderPreview() {
    val basketState = remember { mutableStateOf(BasketState.CHECKOUT_ORDER) }
    TechnoBearProjectTheme {
        CheckoutOrder(basketState)
    }
}

@Composable
fun DeliveryDetails(basketState: MutableState<BasketState>) {

}

@Composable
@Preview(name = "LightDeliveryDetailsPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkDeliveryDetailsPreview"
)
fun DeliveryDetailsPreview() {
    val basketState = remember { mutableStateOf(BasketState.DELIVERY_DETAILS) }
    TechnoBearProjectTheme {
        DeliveryDetails(basketState)
    }
}
