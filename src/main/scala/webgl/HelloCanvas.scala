package webgl


import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.raw.WebGLRenderingContext

import scala.scalajs.js.annotation.JSExport

@JSExport
object HelloCanvas {
  val VShader =
    """
      |void main(){
      |  gl_Position = vec4(0.0,0.0,0.0,1.0);
      |  gl_PointSize = 10.0;
      |}
    """.stripMargin
  val FShader =
    """
      |void main(){
      |  gl_FragColor = vec4(1.0,0.0,0.0,1.0);
      |}
    """.stripMargin
  @JSExport
  def main(canvas:html.Canvas) = {
    val gl = canvas.getContext("webgl").asInstanceOf[WebGLRenderingContext]

    val program = gl.createProgram()
    val vshader = gl.createShader(WebGLRenderingContext.VERTEX_SHADER)
    gl.shaderSource(vshader,VShader)
    gl.compileShader(vshader)
    val fshader = gl.createShader(WebGLRenderingContext.FRAGMENT_SHADER)
    gl.shaderSource(fshader,FShader)
    gl.compileShader(fshader)
    gl.attachShader(program,vshader)
    gl.attachShader(program,fshader)

    gl.linkProgram(program)

    gl.useProgram(program)
    gl.clearColor(0.0,0.0,1.0,1.0)
    gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
    gl.drawArrays(WebGLRenderingContext.POINTS,0,1)
  }

}
