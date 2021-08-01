name := """bookstore"""
organization := "com.me.mauritz"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  guice,
  javaJpa,
  javaJdbc,
  jdbc,
  evolutions,
  "org.hibernate" % "hibernate-core" % "5.4.30.Final",
  "mysql" % "mysql-connector-java" % "8.0.26"
)

PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"