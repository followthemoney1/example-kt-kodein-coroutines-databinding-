package pc.dd.test.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import kotlinx.android.synthetic.main.view_one_user.view.*
import pc.dd.test.adapter.UserAdapter
import pc.dd.test.data.UserResponse

@BindingAdapter(value = ["app:users", "app:adapter"], requireAll = true)
fun setItems(view: RecyclerView, items: UserResponse?, adapter: UserAdapter) {
    if (items != null) {
        adapter.data = items.items
        adapter.notifyDataSetChanged()
    }
}

@BindingAdapter(value = ["app:loadWithUrl"])
fun ImageView.loadWithUrl(src: String) {
    com.bumptech.glide.Glide
        .with(this)
        .load(src)
        .into(this)
}