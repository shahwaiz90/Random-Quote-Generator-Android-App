package com.ahmadshahwaiz.randomprogrammingquotes.domain

import android.content.Context
import androidx.annotation.StringRes


class TextProvider(context: Context) {

    private var _context: Context = LanguageContextWrapper.wrap(context)

    fun getText(@StringRes res: Int, vararg args: Any): String {
        return _context.getString(res, *args)
    }

}