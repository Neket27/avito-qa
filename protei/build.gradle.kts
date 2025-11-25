plugins {
    id("java")
}

group = "avito_qa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("org.testng:testng:7.10.2")
}

tasks.test {
    useJUnitPlatform()
}