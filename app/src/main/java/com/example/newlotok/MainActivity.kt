package com.example.newlotok

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.lotok.ui.theme.LotokTheme
import com.example.newlotok.ui.LotokApp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
            }
        }
        setContent {
            LotokTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LotokApp()
                    /*
                    var moh by remember {
                        mutableStateOf(true)
                    }
                    var isLaunchedEffectFinished by remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        lifecycleScope.launch{
                            val preferences = dataStore.data.first()
                            moh = preferences[SHOW_WELCOME_SCREEN] ?: false
                            isLaunchedEffectFinished = true
                        }
                    }
                    if (isLaunchedEffectFinished){
                        LotokNavHost(
                            showWelcomeScreen = moh,
                            onWelcomeScreenButtonClicked = {
                                lifecycleScope.launch{
                                    dataStore.edit { settings ->
                                        settings[SHOW_WELCOME_SCREEN] = true
                                    }
                                    moh = true
                                }
                            },
                        )
                    }
                     */
                }
            }
        }
    }
}
