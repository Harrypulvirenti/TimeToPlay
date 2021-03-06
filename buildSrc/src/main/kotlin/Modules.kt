object Modules {

    val mobileFeatures: Set<String>
        get() = setOf(
            launchFeature,
            splashFeature,
            homeFeature,
            discoveryFeature,
            collectionFeature,
            profileFeature
        )

    // Features
    const val launchFeature = ":launch-feature"
    const val splashFeature = ":splash-feature"
    const val homeFeature = ":home-feature"
    const val discoveryFeature = ":discovery-feature"
    const val collectionFeature = ":collection-feature"
    const val profileFeature = ":profile-feature"

    const val sharedInterfaces = ":shared-interfaces"
    const val testImplementation = ":test-implementation"
    const val kotlinExtensions = ":extensions-kotlin"
    const val androidExtensions = ":extensions-android"
    const val entities = ":entities"
    const val network = ":network"
    const val dataSources = ":data-sources"
    const val core = ":core"
    const val navigation = ":navigation"
}