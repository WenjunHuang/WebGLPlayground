package macros

import scala.io.Source
import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Assets {
  def includeFile(file: String): String = macro includeFileImpl

  def includeFileImpl(c: blackbox.Context)(file: c.Expr[String]): c.Expr[String] = {
    import c.universe._
    val Literal(Constant(fileName: String)) = file.tree
    val source = Source.fromFile(fileName)
      .getLines().mkString("\n")
    c.Expr[String](Literal(Constant(source)))
  }

}
