package pc.dd.test.data

import com.google.gson.annotations.SerializedName

data class UserResponse(@SerializedName("total_count")
                        val totalCount: Int = 0,
                        @SerializedName("incomplete_results")
                        val incompleteResults: Boolean = false,
                        @SerializedName("items")
                        val items: List<ItemsItem> = emptyList())