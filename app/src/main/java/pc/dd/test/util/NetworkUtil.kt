package pc.dd.test.util

import java.io.IOException
import pc.dd.test.data.objects.main.ResultResponse

suspend fun <T : Any> safeApiCall(call: suspend () -> ResultResponse<T>, errorMessage: String): ResultResponse<T> {
    return try {
        call()
    } catch (e: Exception) {
        // An exception was thrown when calling the API so we're converting this to an IOException
        ResultResponse.Error(IOException(errorMessage, e))
    }
}