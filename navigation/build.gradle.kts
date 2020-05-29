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

    // Koin
    implementation(Libraries.koinAndroid)
}
