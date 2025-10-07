package com.bruteste.myappone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            painter = painterResource(
                id =
                    R.drawable.dinheiro
            ),
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
    var quantity by remember {
        mutableStateOf("")
    }
    Spacer(modifier = Modifier.height(24.dp))
    OutlinedTextField(
        value = quantity,
        onValueChange = { quantity = it },
        label = {
            Text(stringResource(R.string.hint_quantity))
        },
        keyboardOptions =
            KeyboardOptions(
                keyboardType =
                    KeyboardType.Number
            ),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(24.dp))

    val context = LocalContext.current
    var result by remember { mutableStateOf("") }

    Button(
        onClick = {
            if (quantity.isBlank() || price.isBlank()) {
                Toast.makeText(context,context.getString(R.string.empty_fields),
                    Toast.LENGTH_SHORT).show()
            } else {
                val qtd = quantity.toDouble()
                val p = price.toDouble()
                val total = qtd * p
                result =
                    context.getString(R.string.label_result, total)}
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text =
            stringResource(R.string.btn_calculate))
    }
    if (result.isNotEmpty()) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = result,
            fontSize = 18.sp,
            modifier =
                Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


//É essa atualização(rendenização) rapida na tela sem rodar de fato o android
@Preview(showBackground = true)
@Composable
fun MyAppOnePreview() {
    MyAppOneTheme {
        Scaffold (modifier = Modifier.fillMaxSize())
        { innerPadding-> MyAppOne(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}