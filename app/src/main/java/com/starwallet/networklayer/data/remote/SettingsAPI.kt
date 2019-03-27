package com.starwallet.networklayer.data.remote

import com.starwallet.networklayer.BuildConfig

/** Settings Class Contains BASE URL Works with development and production
 *  API_Key for API
 */

class SettingsAPI {
    companion object {
        val apiKey: String = BuildConfig.API_KEY

        val baseUrl: String = BuildConfig.BASE_URL
    }
}
