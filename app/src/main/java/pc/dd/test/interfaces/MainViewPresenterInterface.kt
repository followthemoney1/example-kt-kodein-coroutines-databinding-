package pc.dd.test.interfaces
import UserResponse
import Items
interface MainViewPresenterInterface{
    fun getUsers()
    fun onUsersUpdate( response: UserResponse)
    fun onError()
    fun showUserLocation( user: Items)
}