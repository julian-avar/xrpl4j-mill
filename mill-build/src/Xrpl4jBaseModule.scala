package millbuild

import mill.*
import mill.javalib.*
import mill.scalalib.*
import mill.javalib.publish.*

trait Xrpl4jBaseModule extends MavenModule with PublishModule:
    override def javacOptions   = super.javacOptions() ++ Seq("-source", "1.8", "-target", "1.8")
    override def jvmId          = "zulu:11"
    override def publishVersion = "HEAD-SNAPSHOT"
