package com.bruteste.myappone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bruteste.myappone.ui.theme.MyAppOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //faz experiencias mais modernas na tela toda
        enableEdgeToEdge()
        //define o conteudo da tela com jetpack compose
        setContent {
            MyAppOneTheme {
//ele que gerencia areas
                //fillMaxSize() = fala para o layout ocupar por completo a tela
                //innerPadding = garante que o conteuod nao fique atras da navegaçao/status bar
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAppOne(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
//funcao de construcao da tela/interface
@Composable
//Greeting/atual MyAppOne = funcao que exibe/recebe um nome na tela
fun MyAppOne(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
        // Conteúdo da sua coluna aqui
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id =
                R.drawable.dinheiro),
            contentDescription =
                stringResource(R.string.app_name),
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text =
                stringResource(R.string.app_name),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

//É essa atualização(rendenização) rapida na tela sem rodar de fato o android
@Preview(showBackground = true)
@Composable
fun MyAppOnePreview() {
    MyAppOneTheme {
        MyAppOne()
    }
}