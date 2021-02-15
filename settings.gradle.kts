rootProject.name = "investment-analyser"

pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

include(
  "invest-core",
  "collector",
  "collector-backup"
)
