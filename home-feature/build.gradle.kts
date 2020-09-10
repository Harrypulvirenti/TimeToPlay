import extensions.applyAndroidDefault
import extensions.commonBaseDependencies
import extensions.featureBaseDependencies

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
    id(GradlePlugins.kotlinKapt)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()
    featureBaseDependencies()
}
