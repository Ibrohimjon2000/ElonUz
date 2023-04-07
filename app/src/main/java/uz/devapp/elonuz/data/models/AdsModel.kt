package uz.devapp.elonuz.data.models


import com.google.gson.annotations.SerializedName

data class AdsModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("main_image")
    val main_image: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("images")
    val images: List<String>
)