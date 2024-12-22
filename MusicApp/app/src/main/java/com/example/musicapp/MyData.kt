package com.example.musicapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyData(
    @Json(name = "ads")
    val ads: Ads,
    @Json(name = "country")
    val country: String,
    @Json(name = "country_iso")
    val countryIso: String,
    @Json(name = "has_podcasts")
    val hasPodcasts: Boolean,
    @Json(name = "hosts")
    val hosts: Hosts,
    @Json(name = "offers")
    val offers: List<Any>,
    @Json(name = "open")
    val `open`: Boolean,
    @Json(name = "pop")
    val pop: String,
    @Json(name = "upload_token")
    val uploadToken: String,
    @Json(name = "upload_token_lifetime")
    val uploadTokenLifetime: Int,
    @Json(name = "user_token")
    val userToken: Any
) {
    @JsonClass(generateAdapter = true)
    data class Ads(
        @Json(name = "audio")
        val audio: Audio,
        @Json(name = "big_native_ads_home")
        val bigNativeAdsHome: BigNativeAdsHome,
        @Json(name = "display")
        val display: Display
    ) {
        @JsonClass(generateAdapter = true)
        data class Audio(
            @Json(name = "default")
            val default: Default
        ) {
            @JsonClass(generateAdapter = true)
            data class Default(
                @Json(name = "interval")
                val interval: Int,
                @Json(name = "start")
                val start: Int,
                @Json(name = "unit")
                val unit: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class BigNativeAdsHome(
            @Json(name = "android")
            val android: Android,
            @Json(name = "android_tablet")
            val androidTablet: AndroidTablet,
            @Json(name = "ipad")
            val ipad: Ipad,
            @Json(name = "iphone")
            val iphone: Iphone
        ) {
            @JsonClass(generateAdapter = true)
            data class Android(
                @Json(name = "enabled")
                val enabled: Boolean
            )

            @JsonClass(generateAdapter = true)
            data class AndroidTablet(
                @Json(name = "enabled")
                val enabled: Boolean
            )

            @JsonClass(generateAdapter = true)
            data class Ipad(
                @Json(name = "enabled")
                val enabled: Boolean
            )

            @JsonClass(generateAdapter = true)
            data class Iphone(
                @Json(name = "enabled")
                val enabled: Boolean
            )
        }

        @JsonClass(generateAdapter = true)
        data class Display(
            @Json(name = "interstitial")
            val interstitial: Interstitial
        ) {
            @JsonClass(generateAdapter = true)
            data class Interstitial(
                @Json(name = "interval")
                val interval: Int,
                @Json(name = "start")
                val start: Int,
                @Json(name = "unit")
                val unit: String
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class Hosts(
        @Json(name = "images")
        val images: String,
        @Json(name = "stream")
        val stream: String
    )
}