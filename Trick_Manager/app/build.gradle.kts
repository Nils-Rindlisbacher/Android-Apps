plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.nilsrindlisbacher.trick_manager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nilsrindlisbacher.trick_manager"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(files("..\\app\\src\\main\\java\\com\\nilsrindlisbacher\\trick_manager\\Gson\\gson-2.11.0.jar"))
    implementation(files("..\\\\app\\\\src\\\\main\\\\java\\\\com\\\\nilsrindlisbacher\\\\trick_manager\\\\JSON\\\\json-20240303.jar"))
    implementation(files("..\\\\app\\\\src\\\\main\\\\java\\\\com\\\\nilsrindlisbacher\\\\trick_manager\\\\IOUtils\\\\commons-io-2.16.1.jar"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}