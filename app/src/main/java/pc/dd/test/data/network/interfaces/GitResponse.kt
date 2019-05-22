package pc.dd.test.data.network.interfaces

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import pc.dd.test.data.network.objects.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GitResponse {

    @GET("/search/users")
    fun userListByFollowersAsync(
        @Query("q") q: String = "followers:>1000",
        @Query("sort") sort: String = "contributions",
        @Query("order") order: String = "desc"
    ): Deferred<Response<UserResponse>>

    companion object Factory {
        fun create(): GitResponse {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(GitResponse::class.java)
        }
    }
}