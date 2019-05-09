package pc.dd.test.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pc.dd.test.R
import pc.dd.test.adapter.UserAdapter
import pc.dd.test.databinding.ActivityMainBinding

//TODO: remove this after stable version,
//MARK: for custom method
//@BindingMethods(value = [
//    BindingMethod(
//        type = RecyclerView::class,
//        attribute = "app:set_items",
//        method = "setItems")])

class MainActivity : AppCompatActivity() {

    private val mainViewModel by lazy {
        ViewModelProviders.of(this)
            .get(MainViewModel::class.java)
    }
    private val userAdapter by lazy {
        UserAdapter {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO:using databining for view
        val binding: ActivityMainBinding =
            DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
                    adapter = userAdapter
                    viewModel = mainViewModel
                }
        binding.lifecycleOwner = this

    }

}
