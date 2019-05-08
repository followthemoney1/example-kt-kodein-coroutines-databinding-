package pc.dd.test.util

import kotlinx.coroutines.*
import pc.dd.test.data.UserResponse
import java.io.IOException
import pc.dd.test.data.main.Result

suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        // An exception was thrown when calling the API so we're converting this to an IOException
        Result.Error(IOException(errorMessage, e))
    }
}