package pc.dd.test.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.withContext
import pc.dd.test.data.UserResponse
import pc.dd.test.interfaces.MainViewImnetface
import pc.dd.test.manager.DataManager

class MainViewModel constructor(mainViewInterface: MainViewImnetface) : ViewModel() {
    private val dataManager: DataManager = DataManager()

    private val _users =  MutableLiveData<UserResponse>()
    val users: LiveData<UserResponse>
        get() = _users


    init {
        mainViewInterface.initViews()

        dataManager.getUsersAsync(
            onSuccess = {
            _users.value = it
                print(it)
        },
            onError = {
                print(it)
            })
    }
}