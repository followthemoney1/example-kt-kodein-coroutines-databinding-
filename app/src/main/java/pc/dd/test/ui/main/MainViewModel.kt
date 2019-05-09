package pc.dd.test.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pc.dd.test.data.UserResponse
import pc.dd.test.manager.DataManager

class MainViewModel : ViewModel() {
    private val dataManager: DataManager = DataManager()

    private val _users = MutableLiveData<UserResponse>()
    val users: LiveData<UserResponse>
        get() = _users

    init {
        dataManager.getUsersAsync(
            onSuccess = {
                //MARK: or use  _users.=it if its in main thread
                _users.postValue(it)
                print(it)
            },
            onError = {
                print(it)
            })
    }
}