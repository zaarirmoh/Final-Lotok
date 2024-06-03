package com.example.newlotok

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newlotok.model.Tokens
import com.example.newlotok.ui.LotokApp
import com.example.newlotok.ui.LotokViewModel
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.theme.LotokTheme
import kotlinx.coroutines.launch


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val SHOW_WELCOME_SCREEN = booleanPreferencesKey("show_welcome_screen")
val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
val ACCESS_TOKEN = stringPreferencesKey("access_token")



class MainActivity : ComponentActivity() {
    val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LotokViewModel::class.java)) {
                // Pass the required parameter to the LotokViewModel constructor
                return LotokViewModel(context = applicationContext) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
    private val viewModel by viewModels<LotokViewModel>{ viewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500
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
                    //val startDestination = viewModel.getStartingScreen()
                    val startDestination = LotokScreen.BookingScreen.name
                    LotokApp(
                        onWelcomeScreenButtonClicked = {
                            lifecycleScope.launch{
                                viewModel.changeStartingScreen()
                            }
                        },
                        startDestination = startDestination
                    )
                    val tokensViewModel: TokensViewModel =
                        viewModel(factory = TokensViewModel.Factory)
                    LaunchedEffect(Unit) {
                        lifecycleScope.launch {
                            Log.d("entered here","entered here")
                            val accessToken = viewModel.getAccessToken()
                            val refreshToken = viewModel.getRefreshToken()
                            val tokens = Tokens(accessToken, refreshToken)
                            tokensViewModel.verifyAccessToken(tokens)
                            Log.d("Refresh Token", refreshToken)
                            Log.d("Access Token",accessToken )
                            Log.d("finished here","finished here")
                        }
                    }

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
