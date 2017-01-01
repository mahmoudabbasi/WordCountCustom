import sbtassembly.PathList

name := "WordCountCustom"


version := "1.0"

scalaVersion := "2.11.7"

//libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "0.20.2"




libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.0.2" ,
                            "org.apache.spark" %% "spark-sql" % "2.0.2",
                            "org.apache.spark" %% "spark-streaming" % "2.0.2"
)


unmanagedJars in Compile += file("/data/db2driver/db2jcc4.jar")


    