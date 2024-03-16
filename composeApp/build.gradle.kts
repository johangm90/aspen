import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.kotestMultiplatform)
    alias(libs.plugins.mokkery)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = false
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(libs.sqldelight.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.ktorfit.lib)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.moko.mvvm.core)
            implementation(libs.orbit.core)
            implementation(libs.orbit.compose)
            implementation(libs.coil.core)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.store5)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.transitions)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
            implementation(libs.orbit.test)
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.assertions.core)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }
    }
}

android {
    namespace = "com.jgm90.aspen"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.jgm90.aspen"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.jgm90.aspen")
        }
    }
}
dependencies {
    implementation(libs.androidx.material3.android)
    with(libs.ktorfit.ksp) {
        add("kspCommonMainMetadata", this)
        add("kspAndroid", this)
        add("kspAndroidTest", this)
        add("kspIosX64", this)
        add("kspIosX64Test", this)
        add("kspIosArm64", this)
        add("kspIosArm64Test", this)
        add("kspIosSimulatorArm64", this)
        add("kspIosSimulatorArm64Test", this)
    }
}
