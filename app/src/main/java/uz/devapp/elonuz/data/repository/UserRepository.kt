package uz.devapp.elonuz.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.devapp.elonuz.data.api.NetworkingObject
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.data.models.request.AdsFilter
import uz.devapp.elonuz.data.repository.sealed.DataResult

class UserRepository : BaseRepository() {
    val api = NetworkingObject.getClientInstance()

    suspend fun getCategories() = withContext(Dispatchers.IO) {
        try {
            val response = api.getCategories()
            return@withContext wrapResponse(response)
        } catch (e: Exception) {
            return@withContext DataResult.Error<List<CategoryModel>>(e.localizedMessage)
        }
    }

    suspend fun getAds(filter: AdsFilter) = withContext(Dispatchers.IO) {
        try {
            val response = api.getAds(filter)
            return@withContext wrapResponse(response)
        } catch (e: Exception) {
            return@withContext DataResult.Error<List<AdsModel>>(e.localizedMessage)
        }
    }
}