package app.technobearproject

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

enum class ProductType {
    PHONE,
    TV,
    NONE
}

class ProductItem(val name: String = "",
                  val price: String = "",
                  val image: Int = 0,
                  val description: String = "",
                  val type: ProductType = ProductType.NONE,
                  var selectedAmount: MutableState<String> = mutableStateOf("0"),
                  var basketAmount: MutableState<String> = mutableStateOf("0"))

val itemsWholeList = listOf(
    ProductItem("Smartphone SAMSUNG Galaxy A22 4GB / 128GB (white)",
        "\$599.99",
        R.drawable.galaxya22128gbsma225fzkgser_samsung_60f6e745471be,
        "Type: smartphone\n" +
                "Screen diagonal: 6.4″ \n" +
                "Control type: touch\n" +
                "Number of SIM-cards: 2\n" +
                "SIM-card format: Nano-SIM\n" +
                "Operating system: Android\n" +
                "Operating system version: Android 11.0\n" +
                "Branded graphical interface: One UI\n" +
                "Product Range: Galaxy A22 (Samsung)\n" +
                "Certification: PCT / STB / EAC",
        ProductType.PHONE,
        mutableStateOf("0"),
        mutableStateOf("0")),
    ProductItem("Samsung TV QE55Q67AAUXRU",
        "\$2484.00",
        R.drawable.qe43q60aauxru_samsung_607d5ce61da8f,
        "Type: QLED\n" +
                "Series: 6\n" +
                "Screen dimensions: 43 \"\n" +
                "Permission: 3,840 x 2,160\n" +
                "Screen curvature: No\n" +
                "Anti Reflection: No\n" +
                "HDMI connector: 3\n" +
                "USB: 2 ",
        ProductType.TV,
        mutableStateOf("0"),
        mutableStateOf("0")),
    ProductItem("Smartphone SAMSUNG Galaxy A22 4GB / 128GB (white)",
        "\$599.99",
        R.drawable.galaxya22128gbsma225fzkgser_samsung_60f6e745471be,
        "Type: smartphone\n" +
                "Screen diagonal: 6.4″ \n" +
                "Control type: touch\n" +
                "Number of SIM-cards: 2\n" +
                "SIM-card format: Nano-SIM\n" +
                "Operating system: Android\n" +
                "Operating system version: Android 11.0\n" +
                "Branded graphical interface: One UI\n" +
                "Product Range: Galaxy A22 (Samsung)\n" +
                "Certification: PCT / STB / EAC",
        ProductType.PHONE,
        mutableStateOf("0"),
        mutableStateOf("0")),
    ProductItem("Samsung TV QE55Q67AAUXRU",
        "\$2484.00",
        R.drawable.qe43q60aauxru_samsung_607d5ce61da8f,
        "Type: QLED\n" +
                "Series: 6\n" +
                "Screen dimensions: 43 \"\n" +
                "Permission: 3,840 x 2,160\n" +
                "Screen curvature: No\n" +
                "Anti Reflection: No\n" +
                "HDMI connector: 3\n" +
                "USB: 2 ",
        ProductType.TV,
        mutableStateOf("0"),
        mutableStateOf("0")),
    ProductItem("Smartphone SAMSUNG Galaxy A22 4GB / 128GB (white)",
        "\$599.99",
        R.drawable.galaxya22128gbsma225fzkgser_samsung_60f6e745471be,
        "Type: smartphone\n" +
                "Screen diagonal: 6.4″ \n" +
                "Control type: touch\n" +
                "Number of SIM-cards: 2\n" +
                "SIM-card format: Nano-SIM\n" +
                "Operating system: Android\n" +
                "Operating system version: Android 11.0\n" +
                "Branded graphical interface: One UI\n" +
                "Product Range: Galaxy A22 (Samsung)\n" +
                "Certification: PCT / STB / EAC",
        ProductType.PHONE,
        mutableStateOf("0"),
        mutableStateOf("0")),
    ProductItem("Samsung TV QE55Q67AAUXRU",
        "\$2484.00",
        R.drawable.qe43q60aauxru_samsung_607d5ce61da8f,
        "Type: QLED\n" +
                "Series: 6\n" +
                "Screen dimensions: 43 \"\n" +
                "Permission: 3,840 x 2,160\n" +
                "Screen curvature: No\n" +
                "Anti Reflection: No\n" +
                "HDMI connector: 3\n" +
                "USB: 2 ",
        ProductType.TV,
        mutableStateOf("0"))
)