import extensions.applyAndroidDefault
import extensions.commonBaseDependencies

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()

    implementation(Libraries.appCompat)
    implementation(Libraries.fragment)

    implementation(Libraries.navigationFragment)

    // Koin
    implementation(Libraries.koinAndroid)
}
