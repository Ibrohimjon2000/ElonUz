package uz.devapp.elonuz.data.models


import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("parent_id")
    val parentId: Int,
    @SerializedName("title")
    val title: String
)