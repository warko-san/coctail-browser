import Versions.composeUiVersion
import Versions.coroutinesVersion
import Versions.daggerVersion
import Versions.glideVersion
import Versions.ktxVersion
import Versions.leakCanaryVersion
import Versions.okhttp3Version
import Versions.retrofitVersion
import Versions.timberVersion

object Versions {

    const val androidMinSdkVersion = 28
    const val androidTargetSdkVersion = 33
    const val androidCompileSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"

    // Kotlin
    const val ktxVersion = "1.9.0"

    // Compose
    const val composeUiVersion = "1.3.3"

    // Glide
    const val glideVersion = "4.10.0"

    // Dagger
    const val daggerVersion = "2.44.2"

    // Retrofit
    const val okhttp3Version = "4.9.3"
    const val retrofitVersion = "2.9.0"

    //Coroutines
    const val coroutinesVersion = "1.6.4"

    //Development
    const val leakCanaryVersion = "2.10"

    // Logs + Crash Reporting
    const val timberVersion = "4.7.0"
}

object Deps {
    const val kotlinSdk = "androidx.core:core-ktx:${ktxVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val activityCompose = "androidx.activity:activity-compose:1.6.1"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${leakCanaryVersion}"
    const val composeUi = "androidx.compose.ui:ui:$composeUiVersion"
    const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview:$composeUiVersion"
    const val composeMaterial = "androidx.compose.material:material:1.3.1"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeUiVersion"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:$composeUiVersion"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.0.0"
    const val lifecycleViewModelExtensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:2.0.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${okhttp3Version}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${okhttp3Version}"
    const val gson = "com.google.code.gson:gson:2.9.0"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    const val cicerone = "com.github.terrakok:cicerone:7.1"
    const val timber = "com.jakewharton.timber:timber:${timberVersion}"
    const val fireAnal = "com.google.firebase:firebase-analytics:17.2.2"
    const val crashlytics = "com.google.firebase:firebase-crashlytics:17.1.0"
    const val junit = "junit:junit:4.13.2"
    const val coilImage = "io.coil-kt:coil-compose:2.2.2"
}