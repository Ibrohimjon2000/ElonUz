package uz.devapp.elonuz.data.api

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.devapp.elonuz.MyApp
import uz.devapp.elonuz.utils.Constants
import uz.devapp.elonuz.utils.Constants.BASE_URL
import uz.devapp.elonuz.utils.PrefUtils

object NetworkingObject {
    private var client: Api? = null
    fun initClient() {

        client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader("Token", PrefUtils.getToken())
                            .addHeader("Key", Constants.DEVELOPER_KEY)
                            .build()
                        chain.proceed(request)
                    }
                    .addInterceptor(
                        ChuckerInterceptor.Builder(MyApp.app)
                            .collector(ChuckerCollector(MyApp.app))
                            .maxContentLength(250000L)
                            .redactHeaders(emptySet())
                            .alwaysReadResponseBody(false)
                            .build()
                    )
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun getClientInstance(): Api {
        if (client == null) {
            initClient()
        }
        return client!!
    }
}