package com.ahmadshahwaiz.randomprogrammingquotes.domain

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.LocaleList
import java.util.*

/**
 * Helper class to load correct Context after user changes language.
 */
class LanguageContextWrapper(context: Context) : ContextWrapper(context) {

    companion object {

        fun wrap(context: Context): LanguageContextWrapper {

            val res = context.resources
            val configuration = res.configuration
            val activeLocale = Locale("en")
            configuration.setLocale(activeLocale)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                val localeList = LocaleList(activeLocale)
                LocaleList.setDefault(localeList)
                configuration.setLocales(localeList)
            }
            return LanguageContextWrapper(context.createConfigurationContext(configuration))
        }
    }

}