package com.example.demoday.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demoday.objects.ScreenConstants
import com.example.demoday.ui.screen.SignUpScreen
import com.example.demoday.ui.screen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenConstants.SignUpScreen.route) {
        composable(ScreenConstants.SignUpScreen.route) {
            SignUpScreen(navigationSignIn = {navController.navigate(ScreenConstants.SplashScreen.route)})
        }
        composable(ScreenConstants.SplashScreen.route) {
            SplashScreen()
        }
    }
}