package com.example.demoday.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoday.R
import com.example.demoday.remote.model.SignUpDto
import com.example.demoday.ui.theme.TextFieldColorPlaceHolder
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navigationSignIn: () -> Unit) {
    var nameText by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var againPassword by remember { mutableStateOf("") }
    val vm: MainViewModel = koinViewModel()

    fun initViewModel() {
        val signUpDto = SignUpDto(username = nameText, password = password)

        if (password.length in 8..20 && password == againPassword) {
            vm.signUp(signUpDto).observeForever {
                navigationSignIn.invoke()
            }
        } else {

        }
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .width(325.dp)
                .height(450.dp)
                .background(color = Color.LightGray.copy(alpha = 0.85f))
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
                    .background(color = Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Регистрация",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.White
                )
                TextField(
                    value = nameText,
                    onValueChange = { nameText = it },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    placeholder = {
                        Text(
                            text = "Имя",
                            color = TextFieldColorPlaceHolder,
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    placeholder = {
                        Text(
                            text = "Пароль",
                            color = TextFieldColorPlaceHolder
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                )
                TextField(
                    value = againPassword,
                    onValueChange = { againPassword = it },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    placeholder = {
                        Text(
                            text = "Введите пароль еще раз",
                            color = TextFieldColorPlaceHolder
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                )

                Button(
                    onClick = { initViewModel() },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.padding(top = 25.dp),
                    shape = RoundedCornerShape(1.dp)
                ) {
                    Text(
                        text = "Зарегистрироваться",
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}
