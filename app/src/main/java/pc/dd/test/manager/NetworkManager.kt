package pc.dd.test.manager

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pc.dd.test.interfaces.GitResponse
import retrofit2.Retrofit
import UserResponse
import pc.dd.test.data.User

class NetworkManager{
    val gitResponse:GitResponse = GitResponse.create()

    fun getUsersByFollowers( onUpdate: (UserResponse) -> Unit, onError: (Any) -> Unit ){
       val resultObservable =
           gitResponse.getAllUsersConstant()
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
           .subscribe ({
                   result ->
                Log.e(this.javaClass.name, result.toString())
               onUpdate(result)
           }, { error ->
               onError(error)
           })
    }

    fun getUserByNickName(nick: String, onUpdate: (User) -> Unit, onError: (Any) -> Unit){
        val resultObservable =
            gitResponse.getUserByUsername(nick)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                        result ->
                    Log.e(this.javaClass.name, result.toString())
                    onUpdate(result)
                }, { error ->
                    onError(error)
                })
    }
}