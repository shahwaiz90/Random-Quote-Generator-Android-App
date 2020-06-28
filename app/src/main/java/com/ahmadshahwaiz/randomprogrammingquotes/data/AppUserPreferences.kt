package com.ahmadshahwaiz.randomprogrammingquotes.data

import android.content.Context
import android.content.SharedPreferences

class AppUserPreferences constructor(context: Context) {

    private val userPreferences: SharedPreferences = context.getSharedPreferences(APP_USER_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)

    /**
     * Get the last Quote or [null]
     */
    fun getLastQuote(): String? {
        return userPreferences.getString(PREF_QUOTE, null)
    }

    /**
     * Save Quote or [null]
     */
    fun saveQuote(quoteJson: String) = userPreferences.edit()
            .putString(PREF_QUOTE, quoteJson)
            .apply()

    /**
     * Clear all preferred preferences
     */
    fun clear() {
        userPreferences.edit().apply {
            remove(PREF_QUOTE)
        }.apply()
    }

    companion object {
        private const val APP_USER_PREFERENCES_FILE_NAME = "app_preferences"
        private const val PREF_QUOTE = "PREF_QUOTE"
    }
}