plugins {
    id("java")
}

group = "qa"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {

}

tasks.test {
    useTestNG()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}