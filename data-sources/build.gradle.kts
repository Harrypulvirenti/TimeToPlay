import extensions.applyAndroidDefault
import extensions.arrow
import extensions.commonBaseDependencies
import extensions.implementationProject
import extensions.testImplementationProject
import extensions.testingCommon

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
    id(GradlePlugins.kotlinKapt)
    id(GradlePlugins.kotlinSerialization)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()

    implementationProject(
        Modules.kotlinExtensions,
        Modules.sharedInterfaces,
        Modules.entities,
        Modules.network
    )

    implementation(Libraries.coroutinesCore)

    arrow()

    //    Retrofit 2
    implementation(Libraries.retrofit)

    implementation(Libraries.kotlinSerialization)

    // Koin
    implementation(Libraries.koinAndroid)

    testingCommon()
    testImplementation(TestLibraries.koTestArrow)
    testImplementationProject(Modules.testImplementation)
}
