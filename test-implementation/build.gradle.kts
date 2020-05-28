import extensions.applyAndroidDefault
import extensions.commonBaseDependencies
import extensions.implementationProject

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()

    implementationProject(Modules.sharedInterfaces)

    implementation(TestLibraries.junit)
    implementation(TestLibraries.coroutinesTest)
}
