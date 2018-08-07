package webgl


import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.raw.WebGLRenderingContext

import scala.scalajs.js.annotation.JSExport
import scala.util.{Failure, Success}

@JSExport
object HelloCanvas {
  val vshader =VShader(
    """
      |attribute vec4 a_Position;
      |void main(){
      |  gl_Position = a_Position;
      |  gl_PointSize = 10.0;
      |}
    """.stripMargin)
  val fshader =FShader(
    """
      |precision mediump float;
      |uniform vec4 u_FragColor;
      |void main(){
      | gl_FragColor = u_FragColor;
      |}
    """.stripMargin)

  @JSExport
  def main(canvas: html.Canvas) = {
    val gl = canvas.getContext("webgl").asInstanceOf[WebGLRenderingContext]

    initShaders(gl,vshader,fshader) match {
      case Success(program) =>
        gl.useProgram(program)

        val a_Position = gl.getAttribLocation(program, "a_Position")
        val u_FragColor = gl.getUniformLocation(program, "u_FragColor")

        var gPoints: Seq[(Double, Double)] = Nil
        var gColors: Seq[(Double, Double, Double, Double)] = Nil
        canvas.onmousedown = { ev =>
          println("event")
          var x = ev.clientX
          var y = ev.clientY
          val rect = ev.target.asInstanceOf[html.Element].getBoundingClientRect()

          x = ((x - rect.left) - canvas.width / 2) / (canvas.width / 2)
          y = (canvas.height / 2 - (y - rect.top)) / (canvas.height / 2)
          gPoints = gPoints :+ (x, y)

          if (x >= 0.0 && y >= 0.0)
            gColors = gColors :+ (1.0, 0.0, 0.0, 1.0)
          else if (x < 0.0 && y < 0.0)
            gColors = gColors :+ (0.0, 1.0, 0.0, 1.0)
          else
            gColors = gColors :+ (1.0, 1.0, 1.0, 1.0)

          gl.clearColor(0.0, 0.0, 1.0, 1.0)
          gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)

          gPoints.zip(gColors).foreach { it =>
            val (point, color) = it
            gl.vertexAttrib3f(a_Position, point._1, point._2, 0.0)
            gl.uniform4f(u_FragColor, color._1, color._2, color._3, color._4)
            gl.drawArrays(WebGLRenderingContext.POINTS, 0, 1)
          }
        }
        gl.clearColor(0.0, 0.0, 1.0, 1.0)
        gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
      case Failure(cause)=>
        println(cause)
    }


  }

}
