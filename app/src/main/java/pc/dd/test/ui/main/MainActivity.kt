package pc.dd.test.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pc.dd.test.R
import pc.dd.test.adapter.UserAdapter
import pc.dd.test.interfaces.MainViewImnetface
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pc.dd.test.data.ItemsItem
import pc.dd.test.data.UserResponse

class MainActivity : AppCompatActivity(), MainViewImnetface {

    private lateinit var viewModel: MainViewModel

    private var userAdapter: UserAdapter = UserAdapter {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        viewModel.users.observe(this, Observer {
            onUserUpdate(it!!)
        })
    }

    override fun initViews() {
        recycleView.apply {
            layoutManager = LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
            adapter = userAdapter
        }
    }

    override fun onUserUpdate(response: UserResponse) {
        userAdapter.users = response.items!!
        userAdapter.notifyDataSetChanged()
    }


}
