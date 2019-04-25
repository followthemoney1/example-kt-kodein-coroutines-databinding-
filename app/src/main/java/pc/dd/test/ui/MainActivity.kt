package pc.dd.test.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pc.dd.test.R
import pc.dd.test.adapter.UserAdapter
import pc.dd.test.presenter.MainActivityPresenter
import Items
import pc.dd.test.interfaces.MainViewImnetface
import UserResponse
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pc.dd.test.data.User

class MainActivity : AppCompatActivity(), MainViewImnetface {

    lateinit var presenter:MainActivityPresenter
    lateinit var users: List<Items>
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }

    override fun initViews() {
        userAdapter = UserAdapter() {
            presenter.showUserLocation(it)
        }

        recycleView.apply {
            layoutManager = LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
            adapter = userAdapter
        }

    }

    override fun onUserUpdate(response: UserResponse) {
        userAdapter.users = response.items
        userAdapter.notifyDataSetChanged()
    }

    override fun openMap(user: User) {
        
    }

}
