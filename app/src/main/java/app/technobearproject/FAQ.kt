package app.technobearproject

object FAQ {

    class Question(val question: String, val answer: String)

    val qList = listOf(
        Question(
            "What is this project about??",
            "Answer:\n" +
                    "TechnoBear is a team of four developers, each of whom actively " +
                    "contributes to the development and promotion of the project. In this " +
                    "application, you have the opportunity to make a purchase of various " +
                    "digital equipment using the interface that we have developed for you. " +
                    "Here is our team:\n"
        ),
        Question(
            "Who are the developers of this application?",
            "Answer:\n" +
                    "Our team consists of the next developers:\n" +
                    "1) Alexey Kokhovets - head of the project\n" +
                    "2) Andrey Grishkin - web component developer\n" +
                    "3) Pavel Zhukovsky - mobile application developer\n" +
                    "4) Fedor Miron - project tester and responsible for the API"
        ),
        Question(
            "Who specifically developed this mobile application?",
            "Answer:\n" +
                    "4-year student of the Faculty of Applied Mathematics and Computer Science " +
                    "from 12 group - Zhukovsky Pavel"
        ),
        Question(
            "Can I use other theme in the application?",
            "Answer:\n" +
                    "Of course. Our application provides you opportunity to use either light " +
                    "or dark theme. Just set light or dark theme at the settings of your" +
                    "android phone and application will automatically adapt to it."
        ),
        Question(
            "Where can I find new items to buy?",
            "Answer:\n" +
                    "You can find a number of items to buy in the \"Catalog\" section."
        ),
        Question(
            "Can I filter any products by the category I need?",
            "Answer:\n" +
                    "Certainly. Our catalog has a category selection function that will help " +
                    "you choose a specific product. There is also a product search function."
        ),
        Question(
            "Why should I create an account?",
            "Answer:\n" +
                    "If you create an account, then you will have the opportunity to enter " +
                    "your personal account and specify data about yourself in advance, so as " +
                    "not to enter them every time you specify the data for placing an order."
        ),
        Question(
            "What can I do if I have not found the answer to my question?",
            "Answer:\n" +
                    "If you still haven't found the answer to your question in this section, " +
                    "you can ask it yourself and send it to us. To do this, go to the \"About the " +
                    "company\" section and write to us."
        )
    )
}