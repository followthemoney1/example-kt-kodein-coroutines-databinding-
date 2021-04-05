package pc.dd.test.data.objects.main

sealed class ResultResponse<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultResponse<T>()
    data class Error(val exception: Exception) : ResultResponse<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}