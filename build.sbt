name := "datastructurezoo"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.6"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.google.guava" % "guava" % "25.0-jre"
libraryDependencies += "com.carrotsearch" % "hppc" % "0.8.1"
libraryDependencies += "com.koloboke" % "koloboke-api-jdk8" % "1.0.0"
libraryDependencies += "com.koloboke" % "koloboke-impl-jdk8" % "1.0.0"
libraryDependencies += "net.ontopia" % "ontopia-engine" % "5.3.0"
libraryDependencies += "org.eclipse.collections" % "eclipse-collections" % "9.2.0"
libraryDependencies += "org.eclipse.collections" % "eclipse-collections-api" % "9.2.0"
libraryDependencies += "it.unimi.dsi" % "fastutil" % "8.2.1"

logBuffered := false
parallelExecution in Test := false