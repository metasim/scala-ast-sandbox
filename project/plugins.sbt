
resolvers += "sonatype-public" at "https://oss.sonatype.org/content/repositories/public"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "typesafe-thirdparty" at "http://repo.typesafe.com/typesafe/third-party"

resolvers += "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "sbt-plugin-resleases" at "http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"

resolvers +=  "artifactory" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"



//resolvers += "ERI Nexus" at "http://swdev.elderresearch.com/nexus/content/groups/eri"

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.10.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.1")

// addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "1.1.2")
