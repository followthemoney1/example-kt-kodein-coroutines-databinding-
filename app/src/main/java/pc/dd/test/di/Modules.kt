package pc.dd.test.di

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.erased.*
import pc.dd.test.interfaces.GitResponse
import pc.dd.test.manager.DataManager
import pc.dd.test.manager.NetworkManager
import pc.dd.test.ui.ViewModelFactory
import pc.dd.test.ui.activities.main.MainViewModel
import pc.dd.test.util.bindViewModel

val networkModule = Kodein.Module("network") {
    constant("serverURL") with ""

    bind<GitResponse>() with singleton { GitResponse.create() }
    bind<DataManager>() with singleton { DataManager(instance()) }
    bind<NetworkManager>() with singleton { NetworkManager(instance()) }

    //bind<AuthApi>() with singleton { createWebService<AuthApi>(instance(), instance("serverURL")) }

}

val viewModelModule = Kodein.Module("viewModelModule") {
    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }
    bindViewModel<MainViewModel>() with provider { MainViewModel(instance()) }
}