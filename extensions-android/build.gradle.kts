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

    // Android
    implementation(Libraries.appCompat)
    implementation(Libraries.fragment)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleJava8)

    // Coroutine
    implementation(Libraries.coroutinesCore)
}
