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

    // Coroutine
    implementation(Libraries.coroutinesCore)

    // Koin
    implementation(Libraries.koinAndroid)
}
