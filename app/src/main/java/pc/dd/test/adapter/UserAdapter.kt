package pc.dd.test.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pc.dd.test.R
import Items
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_one_user.view.*

class UserAdapter  (var users: List<Items> = ArrayList(), val itemClick: (item: Items) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_one_user, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(users[position])
    }

    override fun getItemCount() = users.size

    class ViewHolder(view: View, private val itemClick: (item: Items) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(item: Items) {
            with(item) {
                Glide
                    .with(itemView)
                    .load(item.avatar_url)
                    .into(itemView.userAvatar)
                
                itemView.userName.text = item.login
                itemView.showUserLocation.setOnClickListener {
                    itemClick(item)
                }
            }
        }
    }
}