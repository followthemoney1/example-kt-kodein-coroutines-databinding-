package pc.dd.test.manager

import kotlinx.coroutines.*
import pc.dd.test.data.UserResponse
import pc.dd.test.data.main.Result
import pc.dd.test.util.exhaustive

class DataManager {
    private val parentJob = SupervisorJob()
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val bgScope = CoroutineScope(Dispatchers.IO + parentJob)
    private val networkManager = NetworkManager()

    fun getUsersAsync(onSuccess: (UserResponse) -> Unit, onError: (String) -> Unit) = bgScope.launch {
            val result = networkManager.searchUsers()
            mainScope.launch {
                when (result) {
                    is Result.Success -> onSuccess(result.data)
                    is Result.Error -> onError(result.exception.localizedMessage)
                }.exhaustive
            }
        }
}