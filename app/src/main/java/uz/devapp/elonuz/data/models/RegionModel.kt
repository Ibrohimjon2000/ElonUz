package uz.devapp.elonuz.data.models


import com.google.gson.annotations.SerializedName

data class RegionModel(
    @SerializedName("created_at")
    val createdAt: Any,
    @SerializedName("districts")
    val districts: List<DistrictModel>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name_uz")
    val nameUz: String,
    var active: Boolean = false
)