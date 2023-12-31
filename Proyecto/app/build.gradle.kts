plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

//para el login y registro
    id("com.google.gms.google-services")


}


android {
    namespace = "com.example.proyecto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.proyecto"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //añadido a mayores
    implementation ("com.google.android.material:material:1.10.0")

    //Para personalizar los botones

    //implementarlo libreria para la autenticacion
    implementation("com.google.firebase:firebase-auth:22.3.0")

//import firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))

    implementation("com.google.firebase:firebase-analytics")

//para la navegacion
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation( "androidx.navigation:navigation-ui-ktx:2.7.5")

    //Animaciones de los botones de los botones de las actividades
    implementation("com.airbnb.android:lottie:3.4.2")

//Implementar para los maps

    implementation("com.google.android.gms:play-services-maps:18.2.0")

}
