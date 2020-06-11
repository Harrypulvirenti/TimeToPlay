object Modules {

    val mobileFeatures: Set<String>
        get() = setOf(
            splashFeature
        )

    // Features
    const val splashFeature = ":splash-feature"

    const val sharedInterfaces = ":shared-interfaces"
    const val testImplementation = ":test-implementation"
    const val kotlinExtensions = ":extensions-kotlin"
    const val androidExtensions = ":extensions-android"
    const val entities = ":entities"
    const val network = ":network"
    const val core = ":core"
    const val navigation = ":navigation"
}