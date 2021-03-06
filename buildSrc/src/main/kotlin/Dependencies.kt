object Libraries {

    // Kotlin
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // Coroutine
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Arrow
    const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
    const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
    const val arrowMeta = "io.arrow-kt:arrow-meta:${Versions.arrow}"

    // Support libs
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"

    // Lifecycle
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    // Navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Koin
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinExperimental = "org.koin:koin-androidx-ext:${Versions.koin}"

    //         Retrofit 2
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitInterceptor}"
    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    const val kotlinSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinSerializationConverter}"

    const val coilImageLoader = "io.coil-kt:coil:${Versions.coilImageLoader}"

    const val exoPlayerCore = "com.google.android.exoplayer:exoplayer-core:${Versions.exoPlayer}"
    const val exoPlayerUI = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoPlayer}"

    // Logger
    const val logger = "com.orhanobut:logger:${Versions.logger}"
}

object TestLibraries {

    const val junit = "androidx.test.ext:junit-ktx:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val koTestRunner = "io.kotest:kotest-runner-junit5-jvm:${Versions.koTest}"
    const val koTestAssertionsCore = "io.kotest:kotest-assertions-core-jvm:${Versions.koTest}"
    const val koTestProperty = "io.kotest:kotest-property-jvm:${Versions.koTest}"
    const val koTestArrow = "io.kotest:kotest-assertions-arrow-jvm:${Versions.koTest}"
    const val koTestKoin = "io.kotest:kotest-extensions-koin-jvm:${Versions.koTest}"
    const val koTestAndroid = "io.kotest:kotest-assertions-android:${Versions.koTest}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    const val lifecycleTest = "androidx.arch.core:core-testing:${Versions.lifecycleTest}"

    const val koinTesting = "org.koin:koin-test:${Versions.koin}"

    const val flowTesting = "com.github.ologe:flow-test-observer:${Versions.flowTesting}"

    const val retrofitMockWebServer =
        "com.squareup.okhttp3:mockwebserver:${Versions.retrofitMockWebServer}"
    const val guava = "com.google.guava:guava:${Versions.guava}"
}