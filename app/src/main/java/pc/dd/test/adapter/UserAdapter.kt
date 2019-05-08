package pc.dd.test.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_one_user.view.*
import pc.dd.test.R
import pc.dd.test.data.ItemsItem

class UserAdapter(var users: List<ItemsItem> = ArrayList(),
                  val itemClick: (item: ItemsItem) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_one_user, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindForecast(users[position])

    override fun getItemCount() = users.size

    class ViewHolder(view: View, private val itemClick: (item: ItemsItem) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(item: ItemsItem) {
            with(item) {
                Glide
                    .with(itemView)
                    .load(item.avatarUrl)
                    .into(itemView.userAvatar)
                
                itemView.userName.text = item.login
                itemView.showUserLocation.setOnClickListener {
                    itemClick(item)
                }
            }
        }
    }
}