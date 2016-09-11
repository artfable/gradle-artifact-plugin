package com.github.artfable.gradle

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
        project.tasks.create("javadocJar", Jar::class.java, {
            it.classifier = "javadoc"
            it.from("build/docs/javadoc")
        })
        project.tasks.create("sourceJar", Jar::class.java, {
            it.from((project.findProperty("sourceSets") as DefaultSourceSetContainer).getByName("main").allSource)
            it.classifier = "sources"
        })

    }
}