package uz.devapp.elonuz.utils

import com.orhanobut.hawk.Hawk
import uz.devapp.elonuz.MyApp

object PrefUtils {
    const val PREF_TOKEN = "token"

    fun init() {
        Hawk.init(MyApp.app).build()
    }

    fun setToken(value: String?) {
        Hawk.put(PREF_TOKEN, value)
    }

    fun getToken(): String {
        return Hawk.get(PREF_TOKEN, "")
    }

    fun clear() {
        Hawk.deleteAll()
    }
}