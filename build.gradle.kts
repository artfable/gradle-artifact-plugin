group = "com.artfable.gradle"
version = "0.0.2"

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
    }
}

plugins {
    java
    kotlin("jvm") version "1.5.21"
    id("com.jfrog.artifactory") version "4.24.14"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(gradleApi())
    implementation(localGroovy())
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

val user = if (project.hasProperty("artifactoryUser")) {
    project.ext["artifactoryUser"]
} else System.getenv("ARTIFACTORY_USER")
val key = if (project.hasProperty("artifactoryKey")) {
    project.ext["artifactoryKey"]
} else System.getenv("ARTIFACTORY_KEY")

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
//            artifact(tasks["sourceJar"])
//            artifact(tasks["javadocJar"])

            pom {
                description.set("Simple plugin that adds two tasks for make source an javadoc jar")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://github.com/artfable/gradle-artifact-plugin/master/LICENSE")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("artfable")
                        name.set("Artem Veselov")
                        email.set("art-fable@mail.ru")
                    }
                }
            }
        }
    }
}

artifactory {
    setContextUrl("https://artfable.jfrog.io/artifactory/")
    publish {
        repository {
            setRepoKey("default-maven-local")
            setUsername(user)
            setPassword(key)
        }
        defaults {
            publications ("mavenJava")

            setPublishArtifacts(true)
            setPublishPom(true)
            setPublishIvy(false)
        }
    }
}