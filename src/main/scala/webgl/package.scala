import org.scalajs.dom.raw.{WebGLProgram, WebGLRenderingContext}

import scala.util.{Success, Try}

package object webgl {

  case class VShader(value: String) extends AnyVal

  case class FShader(value: String) extends AnyVal

  def initShaders(gl: WebGLRenderingContext, vshaderSrc: VShader, fshaderSrc: FShader):Try[WebGLProgram] = {
    val program = gl.createProgram()
    val vshader = gl.createShader(WebGLRenderingContext.VERTEX_SHADER)
    gl.shaderSource(vshader, vshaderSrc.value)
    gl.compileShader(vshader)
    val fshader = gl.createShader(WebGLRenderingContext.FRAGMENT_SHADER)
    gl.shaderSource(fshader, fshaderSrc.value)
    gl.compileShader(fshader)
    gl.attachShader(program, vshader)
    gl.attachShader(program, fshader)
    gl.linkProgram(program)

    Success(program)
  }
}
