package pc.dd.test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_one_user.view.*
import pc.dd.test.R
import pc.dd.test.data.network.objects.ItemsItem
import pc.dd.test.util.loadWithUrl

class UserAdapter(
    var data: List<ItemsItem> = ArrayList(),
    var itemClick: ((item: ItemsItem) -> Unit?)? = null
) : androidx.recyclerview.widget.RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_one_user, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindForecast(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(view: View, private val itemClick: ((item: ItemsItem) -> Unit?)? = null) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        fun bindForecast(item: ItemsItem) {
            with(itemView){
                userAvatar.loadWithUrl(item.avatarUrl)
                userName.text = item.login
                showUserLocation.setOnClickListener {
                    itemClick?.invoke(item)
                }
            }
        }
    }
}