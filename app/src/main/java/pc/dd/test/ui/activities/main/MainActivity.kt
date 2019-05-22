package pc.dd.test.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import pc.dd.test.R
import pc.dd.test.databinding.ActivityMainBinding
import pc.dd.test.ui.adapters.UserAdapter
import pc.dd.test.util.viewModel

//TODO: remove this after stable version,
//MARK: for custom method
//@BindingMethods(value = [
//    BindingMethod(
//        type = RecyclerView::class,
//        attribute = "app:set_items",
//        method = "setItems")])

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val mainViewModel:MainViewModel by viewModel()

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
