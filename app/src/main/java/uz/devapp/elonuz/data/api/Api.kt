package uz.devapp.elonuz.data.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.data.models.RegionModel
import uz.devapp.elonuz.data.models.request.AdsFilter
import uz.devapp.elonuz.data.models.request.LoginRequest
import uz.devapp.elonuz.data.models.request.RegistrationRequest
import uz.devapp.elonuz.data.models.response.AuthResponse
import uz.devapp.elonuz.data.models.response.BaseResponse

interface Api {
    @GET("api/categories")
    suspend fun getCategories(): Response<BaseResponse<List<CategoryModel>>>

    @POST("api/advertisements")
    suspend fun getAds(@Body request: AdsFilter): Response<BaseResponse<List<AdsModel>>>

    @GET("api/regions")
    suspend fun getRegions(): Response<BaseResponse<List<RegionModel>>>

    @POST("api/registration")
    suspend fun registration(@Body request: RegistrationRequest): Response<BaseResponse<AuthResponse>>

    @POST("api/login")
    suspend fun login(@Body request: LoginRequest): Response<BaseResponse<AuthResponse>>

    @Multipart
    @POST("api/advertisements/add")
    suspend fun addAds(
        @Part mainImage: MultipartBody.Part,
        @Part("category_id") categoryId: RequestBody,
        @Part("region_id") regionId: RequestBody,
        @Part("district_id") districtId: RequestBody,
        @Part("name") name: RequestBody,
        @Part("comment") comment: RequestBody,
        @Part("price") price: RequestBody,
        @Part("address") address: RequestBody,
        @Part("phone") phone: RequestBody,
    ): Response<BaseResponse<Boolean>>
}