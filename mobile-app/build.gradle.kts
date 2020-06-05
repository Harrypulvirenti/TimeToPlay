import Modules.core
import Modules.mobileFeatures
import extensions.applyAndroidDefault
import extensions.commonBaseDependencies
import extensions.implementationProject

plugins {
    id(GradlePlugins.androidApplication)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
}

applyAndroidDefault(ApplicationId.mobile)

dependencies {
    commonBaseDependencies()

    implementationProject(core)
    implementationProject(mobileFeatures)

    implementation(Libraries.appCompat)
    implementation(Libraries.koinAndroid)
}
