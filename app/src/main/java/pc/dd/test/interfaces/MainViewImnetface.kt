package pc.dd.test.interfaces
import UserResponse
import pc.dd.test.data.User

interface MainViewImnetface{
    fun initViews()
    fun onUserUpdate( response: UserResponse)
    fun openMap(user: User)
}