package ru.thbank.thb_currency_app.ui

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import ru.thbank.thb_currency_app.R
import ru.thbank.thb_currency_app.domain.MainState
import ru.thbank.thb_currency_app.ui.theme.ForestGreen

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        setContent {
            val mainState = viewModel.mainState.collectAsState().value

            when(mainState){
                is MainState.Success -> {
                    Success()
                }
                is MainState.Loading -> {
                    Loading()
                }
                is MainState.Error -> {
                    Error()
                }
            }



        }
    }
    @Composable
    fun Success(){
        Column(Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .weight(.2f)
                .fillMaxWidth()){
                TopAppBar(viewModel = viewModel).execute()
            }
            Box(modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth()){
                CurrencyBuySell().execute()
            }
            Box(modifier = Modifier
                .weight(0.6f)
                .fillMaxWidth()){
                CurrencyList(viewModel = viewModel).execute()
            }
            Box(modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth()){
                FooterDisclaimer().execute()
            }
        }
    }
    @Composable
    fun Loading(){
        Image(
            painterResource(id = R.drawable.thb_logo_image),
            contentDescription = "Thbank logo",
            modifier = Modifier
                .fillMaxSize(1f)
                .background(ForestGreen)
        )
    }
    @Composable
    fun Error(){
        Image(
            painterResource(id = R.drawable.thb_logo_image),
            contentDescription = "Thbank logo",
            modifier = Modifier
                .fillMaxSize(1f)
                .background(ForestGreen)
        )
    }
}


