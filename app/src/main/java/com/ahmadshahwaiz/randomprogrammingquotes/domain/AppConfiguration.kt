package com.ahmadshahwaiz.randomprogrammingquotes.domain

import com.ahmadshahwaiz.randomprogrammingquotes.BuildConfig.LOGS_ENABLED
import com.ahmadshahwaiz.randomprogrammingquotes.BuildConfig.QUOTE_API_HOST

/**
 * Wrapper class that reads the values from BuildConfig.
 *
 * In the future it can be split up into smaller classes if we want to scope access to parameters.
 */

class AppConfiguration {
    val logsEnabled = LOGS_ENABLED
    val apiHost = QUOTE_API_HOST

}