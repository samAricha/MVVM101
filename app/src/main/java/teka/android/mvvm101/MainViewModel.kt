package teka.android.mvvm101

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _counter = mutableStateOf(0)
    val counter: State<Int> = _counter

    fun add(){
        _counter.value ++
    }

}