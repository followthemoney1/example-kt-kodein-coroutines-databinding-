package pc.dd.test.interfaces

import pc.dd.test.data.ItemsItem
import pc.dd.test.data.UserResponse

interface MainViewPresenterInterface{
    fun getUsers()
    fun onUsersUpdate( response: UserResponse)
    fun onError()
    fun showUserLocation( user: ItemsItem)
}