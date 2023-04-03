/*
 * Copyright 2020-2024 Björn Kautler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.kautler.util

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.npm(
    dependency: Provider<MinimalExternalModuleDependency>
): Dependency {
    val dep = dependency.get()
    return npm(
        name = if (dep.group == "<unscoped>") dep.name else "@${dep.group}/${dep.name}",
        version = dep.version!!
    )
}