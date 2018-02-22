name := "effTest"

version := "1.0"

scalaVersion := "2.12.0"

resolvers ++= Seq(
  "mmz-repository" at "http://maven.admin.srf.ch"
)

libraryDependencies += "org.atnos" %% "eff" % "3.0.4"
libraryDependencies +="org.atnos" %% "eff-scalaz" % "3.0.4"

// to write types like Reader[String, ?]
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

// to get types like Reader[String, ?] (with more than one type parameter) correctly inferred for scala 2.11 < 2.11.9
// you can use the [Typelevel Scala compiler](http://typelevel.org/scala)
scalaOrganization in ThisBuild := "org.typelevel"

// to get types like Reader[String, ?] (with more than one type parameter) correctly inferred for scala 2.12.x
scalacOptions += "-Ypartial-unification"

projectDependencies ++= Seq(
  "ch.srf" %% "ais-client-scala" % "0.0.61",
  "ch.srf" %% "ais-assetimporter-client-scala" % "0.0.89",
  "ch.srf" %% "trec-client-scala" % "1.0.102",
  "ch.srf" %% "tms-client-scala" % "0.0.38",
  "co.fs2" %% "fs2-io" % "0.10.0-M8",
  "ch.srf" %% "scalaz-fs2-lib" % "0.7"
)
    