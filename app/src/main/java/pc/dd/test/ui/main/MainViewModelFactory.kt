package pc.dd.test.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import pc.dd.test.interfaces.MainViewImnetface

class MainViewModelFactory constructor(
    private val mainViewInterface: MainViewImnetface
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != MainViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return MainViewModel(
           mainViewInterface
        ) as T
    }
}