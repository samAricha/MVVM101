package teka.android.mvvm101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import teka.android.mvvm101.ui.theme.MVVM101Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels()
        setContent {
            MVVM101Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MySimpleUi(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun MySimpleUi(viewModel: MainViewModel){

    Box(
        modifier = Modifier.fillMaxSize()
            ,

        ){
        Text(
            viewModel.counter.value.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .size(100.dp)
        )
        
        FloatingActionButton(
            onClick = {
                        viewModel.add()
                      },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(imageVector = Icons.Default.Add,
                tint = Color.White,
                contentDescription = "add btn")
            
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MyPreview(){
    val fakeViewModel = MainViewModel()
    MySimpleUi(fakeViewModel)
}

