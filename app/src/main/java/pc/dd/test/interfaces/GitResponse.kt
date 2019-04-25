package pc.dd.test.interfaces

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import UserResponse
import io.reactivex.Observable
import pc.dd.test.data.User
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

interface GitResponse {
    @GET("/search/users")
    fun userListByFollowers( @Query("q") q: String, @Query("sort") sort: String,@Query("order") order: String): Object

    @GET("/search/users?q=followers:>1000&sort=contributions&order=desc")
    fun getAllUsersConstant(): Observable<UserResponse>

    @GET("/users/{username}")
    fun getUserByUsername(@Path("username") username:String) : Observable<User>

    companion object Factory {
        fun create(): GitResponse {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com")
                .build()

            return retrofit.create(GitResponse::class.java);
        }
    }
}