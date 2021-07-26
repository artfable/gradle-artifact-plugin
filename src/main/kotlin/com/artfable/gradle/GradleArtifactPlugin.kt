package com.artfable.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.tasks.DefaultSourceSetContainer
import org.gradle.api.tasks.bundling.Jar

/**
 * @author artfable
 * 11.09.16
 */
open class GradleArtifactPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("javadocJar", Jar::class.java) {
            this.archiveClassifier.set("javadoc")
            this.from("build/docs/javadoc")
        }
        project.tasks.create("sourceJar", Jar::class.java) {
            this.archiveClassifier.set("sources")
            this.from((project.findProperty("sourceSets") as DefaultSourceSetContainer).getByName("main").allSource)
        }

        val credentials = project.extensions.create("artifactoryCredentials", ArtifactoryCredentialsExtension::class.java)

        credentials.user = if (project.hasProperty("artifactoryUser")) {
            project.property("artifactoryUser").toString()
        } else System.getenv("ARTIFACTORY_USER")

        credentials.key = if (project.hasProperty("artifactoryKey")) {
            project.property("artifactoryKey").toString()
        } else System.getenv("ARTIFACTORY_KEY")

    }

    open class ArtifactoryCredentialsExtension {
        var user: String? = null
        var key: String? = null
    }
}