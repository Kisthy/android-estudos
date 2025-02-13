package com.example.teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teste.ui.theme.TesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var texto by remember {
        mutableStateOf("")
    }

    var idade by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(32.dp)){
        TextField(
            value = texto,
            onValueChange = {letra ->
                texto = letra
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text="Qual o seu nome?")
            },
            placeholder = {
                Text(text="Digite o nome e o sobrenome.")
            },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.settings_24),
                    contentDescription = "configurações"
                )
            },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.person_24),
                    contentDescription = "configurações"
                )
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        )
        TextField(
            value = idade,
            onValueChange = {letra ->
                idade = letra
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            label = {
                Text(text="Qual a sua idade?")
            },
            placeholder = {
                Text(text="Digite um número.")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
//                color = Color.Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Gray,
                cursorColor = Color.Red
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = "Qual o seu email?")
            },
            placeholder = {
                Text(text = "Digite o seu email?")
            },
            shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Yellow
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TesteTheme {
        Greeting()
    }
}