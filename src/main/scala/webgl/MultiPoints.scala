package webgl

import org.scalajs.dom.html
import org.scalajs.dom.raw.{WebGLProgram, WebGLRenderingContext}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.typedarray.Float32Array
import scala.util.Success

@JSExport
object MultiPoints {
  import WebGLRenderingContext._
  val VShaderSource = VShader(
    """
      |attribute vec4 a_Position;
      |void main(){
      |    gl_Position = a_Position;
      |}
    """.stripMargin)

  val FShaderSource =FShader(
    """
      |void main(){
      | gl_FragColor = vec4(1.0,0.0,0.0,1.0);
      |}
    """.stripMargin)

  @JSExport
  def main(canvas:html.Canvas):Unit = {
    val gl = canvas.getContext("webgl").asInstanceOf[WebGLRenderingContext]
    initShaders(gl,VShaderSource,FShaderSource) match {
      case Success(program) =>
        gl.clearColor(0.0,0.0,0.0,1.0)
        gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
        val n = initVertexBuffers(gl,program)
        gl.useProgram(program)
        gl.drawArrays(TRIANGLE_STRIP,0,n)
    }
  }

  private def initVertexBuffers(gl:WebGLRenderingContext,program:WebGLProgram) :Int= {
    val vertices = new Float32Array(js.Array(
      -0.5f,0.5f,
      -0.5f,-0.5f,
      0.5f,0.5f,
      0.5f,-0.5f))
    val n =4


    val vertexBuffer = gl.createBuffer()
    gl.bindBuffer(ARRAY_BUFFER,vertexBuffer)
    gl.bufferData(ARRAY_BUFFER,vertices,WebGLRenderingContext.STATIC_DRAW)

    val a_Position = gl.getAttribLocation(program,"a_Position")
    gl.vertexAttribPointer(a_Position,2,WebGLRenderingContext.FLOAT,false,0,0)
    gl.enableVertexAttribArray(a_Position)
    n
  }


}
