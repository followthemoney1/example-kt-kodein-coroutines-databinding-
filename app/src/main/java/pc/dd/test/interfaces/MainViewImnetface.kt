package pc.dd.test.interfaces

import pc.dd.test.data.UserResponse

interface MainViewImnetface{
    fun initViews()
    fun onUserUpdate( response: UserResponse)
    //fun openMap(user: User)
}