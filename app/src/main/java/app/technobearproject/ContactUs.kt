package app.technobearproject

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.technobearproject.ui.theme.TechnoBearProjectTheme

@Composable
fun ContactUs() {
    val context = LocalContext.current
    var mail by rememberSaveable { mutableStateOf("") }
    var feedback by rememberSaveable { mutableStateOf("") }
    Column {
        Text(text = stringResource(R.string.contact_us),
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            fontSize = 48.sp,
            textAlign = TextAlign.Center)
        TextField(
            value = mail,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            onValueChange = {
                mail = it
            },
            label = { Text("Enter your mail here:") },
            maxLines = 1
        )
        TextField(
            value = feedback,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            onValueChange = {
                feedback = it
            },
            label = { Text("Write here your question or feedback:") },
            maxLines = 16
        )
        Button(onClick = {
            if (mail.isNotEmpty() and mail.contains('@')) {
                if (feedback.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        "Your feedback has been sent to $mail, we will contact you soon.",
                        Toast.LENGTH_LONG
                    ).show()
                    mail = ""
                    feedback = ""
                } else {
                    Toast.makeText(
                        context,
                        "Your feedback is empty. Enter some information, please...",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Entered mail is empty or incorrect. Please, try to enter correct mail...",
                    Toast.LENGTH_LONG
                ).show()
            }
        }, modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.send_feedback),
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center)
        }
    }
}

@Composable
@Preview(name = "LightContactUsPreview")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkContactUsPreview"
)
fun ContactUsPreview() {
    TechnoBearProjectTheme {
        ContactUs()
    }
}