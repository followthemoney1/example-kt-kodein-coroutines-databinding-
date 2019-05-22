package pc.dd.test.ui.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pc.dd.test.data.network.objects.UserResponse
import pc.dd.test.data.network.managers.DataManager

class MainViewModel(val dataManager: DataManager) : ViewModel() {

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