package eri

import scala.tools.nsc.GenericRunnerSettings
import scala.tools.nsc.interpreter.IMain
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

/**
 *
 */
object ScalaInterpreter extends App {
  {
    val settings: GenericRunnerSettings = new GenericRunnerSettings(error => println(error));

    settings.usejavacp.value = true
    settings.verbose.value = true

    val interpreter: IMain = new IMain(settings)

    val r = interpreter.interpret("val r = 1 + 3")

    print(r)
  }

  {
    val tb = runtimeMirror(getClass.getClassLoader).mkToolBox()
    val r = tb.parse("val a =34; val q = a + b - 4")

    showRaw(r, printTypes = true)

    val build = scala.reflect.runtime.universe.build

    val x = build.setTypeSignature(build.newFreeTerm("x", 2), typeOf[Int])

    r.tpe

    r.symbol

    r.freeTerms

    r.freeTypes

    // have two trees:
    // 1. Tree with all the defined identifiers (parameters)
    // 2. Tree with changing function definition
    // 3. Parse and merge as needed
    //

    // See: http://stackoverflow.com/a/12123609/296509

    object undefFinder extends Traverser {
      override def traverse(tree: Tree): Unit = tree match {
        case i @ Ident(x) =>
          println(s"$x : ${i.tpe}, ${x.toTypeName}")
        case _ => super.traverse(tree)
      }
    }

    undefFinder.traverse(r)

  }
}
