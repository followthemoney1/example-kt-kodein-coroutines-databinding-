package pc.dd.test.manager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import pc.dd.test.data.UserResponse
import pc.dd.test.data.main.Result
import pc.dd.test.util.exhaustive

class DataManager(val networkManager:NetworkManager) {

    private val parentJob = SupervisorJob()
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val bgScope = CoroutineScope(Dispatchers.IO + parentJob)

    fun getUsersAsync(onSuccess: (UserResponse) -> Unit, onError: (String) -> Unit) = bgScope.launch {
            val result = networkManager.searchUsers()
                when (result) {
                    is Result.Success -> onSuccess(result.data)
                    is Result.Error -> onError(result.exception.localizedMessage)
                }.exhaustive
        }
}