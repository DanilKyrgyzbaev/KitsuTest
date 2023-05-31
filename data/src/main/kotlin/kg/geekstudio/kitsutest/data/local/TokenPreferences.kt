package kg.geekstudio.kitsutest.data.local

import android.content.Context
import android.content.SharedPreferences

object TokenPreferences  {
    private const val PREF_NAME = "mySharedPreferences"
    private lateinit var sharedPreferences: SharedPreferences

    fun initSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    var userAccessToken: String
        get() = sharedPreferences.getString("userToken", userRefreshToken).toString()
        set(value) = sharedPreferences.edit().putString("userToken", value).apply()

    var userRefreshToken: String
        get() = sharedPreferences.getString("userToken", "").toString()
        set(value) = sharedPreferences.edit().putString("userToken", value).apply()
}