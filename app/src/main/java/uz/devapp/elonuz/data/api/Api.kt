package uz.devapp.elonuz.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.data.models.request.AdsFilter
import uz.devapp.elonuz.data.models.response.BaseResponse

interface Api {
    @GET("api/categories")
    suspend fun getCategories(): Response<BaseResponse<List<CategoryModel>>>

    @POST("api/advertisements")
    suspend fun getAds(@Body request: AdsFilter): Response<BaseResponse<List<AdsModel>>>
}