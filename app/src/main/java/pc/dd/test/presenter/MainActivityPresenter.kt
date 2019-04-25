package pc.dd.test.presenter

import pc.dd.test.interfaces.MainViewPresenterInterface
import pc.dd.test.manager.NetworkManager
import UserResponse
import pc.dd.test.interfaces.MainViewImnetface
import Items

class MainActivityPresenter : MainViewPresenterInterface {

    val networkManager: NetworkManager = NetworkManager()
    var mainViewInterface: MainViewImnetface

    constructor(mainViewInterface: MainViewImnetface) {
        this.mainViewInterface = mainViewInterface
        mainViewInterface.initViews()
    }

    init {
        getUsers()
    }

    override fun getUsers() {
        networkManager
            .getUsersByFollowers(
                onUpdate = {
                    onUsersUpdate(response = it)
                },
                onError = {

                })
    }

    override fun onUsersUpdate(response: UserResponse) {
        mainViewInterface.onUserUpdate(response)
    }

    override fun onError() {

    }

    override fun showUserLocation(user: Items) {
        networkManager.getUserByNickName(user.login,
            onUpdate = {
                mainViewInterface.openMap(it)
            },
            onError = {

            })
    }
}