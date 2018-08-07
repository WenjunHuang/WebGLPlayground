package webgl

import org.scalajs.dom.html
import org.scalajs.dom.raw.WebGLRenderingContext

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.typedarray.Float32Array
import scala.util.Success

@JSExport
object MultiPoints {
  val VShaderSource = VShader(
    """
      |attribute vec4 a_Position;
      |void main(){
      |    gl_Position = a_Position;
      |    gl_PointSize = 10.0;
      |}
    """.stripMargin)

  val FShaderSource =FShader(
    """
      |
    """.stripMargin)

  @JSExport
  def main(canvas:html.Canvas):Unit = {
    val gl = canvas.getContext("webgl").asInstanceOf[WebGLRenderingContext]
    initShaders(gl,VShaderSource,FShaderSource) match {
      case Success(program) =>
        gl.clearColor(0.0,0.0,0.0,1.0)
        gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
    }
  }

  private def initVertexBuffers(gl:WebGLRenderingContext) = {
    val vertices = new Float32Array(js.Array(0.0f,0.5f,-0.5f,-0.5f,0.5f,-0.5f))
    val n =3
    val vertexBuffer = gl.createBuffer()
    gl.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER,vertexBuffer)
    gl.bufferData(WebGLRenderingContext.ARRAY_BUFFER,vertices,WebGLRenderingContext.STATIC_DRAW)
  }


}
