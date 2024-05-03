package com.example.newlotok.ui.screens.welcomeScreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.theme.LotokTheme
import com.example.newlotok.R


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit,
) {
    val redContainerImage = painterResource(id = R.drawable.red_container)
    val redCar = painterResource(id = R.drawable.red_car)
    val text = stringResource(id = R.string.welcome_screen_text)
    val words = text.split(" ")
    val buttonColor = Color(android.graphics.Color.parseColor("#B3261E"))
    val buttonText = stringResource(id = R.string.get_Started)
    Column(modifier = modifier) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = redContainerImage,
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.TopEnd),

                contentScale = ContentScale.FillWidth

            )

            Spacer(modifier = modifier.height(55.dp))

            Image(
                painter = redCar,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 386.dp, height = 241.dp)
                    .align(Alignment.BottomCenter)

            )
        }
        Spacer(modifier = modifier.height(55.dp))

        Column(
            modifier= modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(words.take(2).joinToString(" "))
                    }
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append(" ${words.getOrNull(2) ?: ""}")
                    }
                },
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = words.getOrNull(3) ?: "",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                )
        }


        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = onButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .size(57.dp)
                .padding(start = 20.dp, end = 20.dp ),


            colors = ButtonDefaults.buttonColors(buttonColor)
        ) {
            Text( text = buttonText, fontSize = 18.sp , color = Color.White   , fontWeight = FontWeight.Bold  )
        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview(){
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
    LotokTheme {
        //WelcomeScreen(onButtonClicked = {})
    }
    }

}