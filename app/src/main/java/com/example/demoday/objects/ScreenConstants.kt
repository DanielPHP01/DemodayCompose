package com.example.demoday.objects

sealed class ScreenConstants(val route: String){
    object SignUpScreen : ScreenConstants("sign_up_screen")
    object SplashScreen : ScreenConstants("splash_screen")
}