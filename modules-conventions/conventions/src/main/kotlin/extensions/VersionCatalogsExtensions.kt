package extensions

import org.gradle.api.artifacts.VersionCatalog

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

fun VersionCatalog.getVersion(alias: String) = this.findVersion(alias).get().toString()

fun VersionCatalog.getLibrary(alias: String) = this.findLibrary(alias).get()

fun VersionCatalog.getBundle(alias: String) = this.findBundle(alias).get()