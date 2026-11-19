import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
}

// URL de la API en debug.
// Por defecto 10.0.2.2 (el emulador ve el ordenador anfitrión; vale en Windows, Linux y Mac).
// Cada persona puede cambiarla SOLO en su local.properties (no se sube a git):
//     api.debug.url=http://localhost:8080/
val localProps = Properties().apply {
    val f = rootProject.file("local.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}
val apiDebugUrl: String = localProps.getProperty("api.debug.url", "http://10.0.2.2:8080/")

android {

    buildFeatures {
        buildConfig = true
    }

    namespace = "com.cidead.pmdm.altocampo"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.cidead.pmdm.altocampo"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        debug {
            buildConfigField("String", "API_BASE_URL", "\"$apiDebugUrl\"")
        }
        release {
            buildConfigField("String", "API_BASE_URL", "\"https://TU_DOMINIO/\"")
            optimization {
                enable = false
            }
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}