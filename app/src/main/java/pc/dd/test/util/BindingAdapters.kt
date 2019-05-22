package pc.dd.test.util

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import pc.dd.test.ui.adapters.UserAdapter
import pc.dd.test.data.UserResponse

@BindingAdapter(value = ["app:users", "app:adapter"], requireAll = true)
fun setItems(view: androidx.recyclerview.widget.RecyclerView, items: UserResponse?, adapter: UserAdapter) {
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