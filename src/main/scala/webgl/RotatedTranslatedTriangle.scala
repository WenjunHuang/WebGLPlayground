package webgl

import macros.Assets
import org.scalajs.dom.html
import org.scalajs.dom.raw.WebGLRenderingContext

import scala.scalajs.js.annotation.JSExport
import glmatrix._

@JSExport
object RotatedTranslatedTriangle {

  import WebGLRenderingContext._

  val VShaderSource = VShader(Assets.includeFile("src/main/resources/rotated_translated_vshader.glsl"))
  val FShaderSource = FShader(Assets.includeFile("src/main/resources/red_fshader.glsl"))

  @JSExport
  def main(canvas: html.Canvas) = {
    val gl = canvas.getContext("webgl").asInstanceOf[WebGLRenderingContext]
    val program = initShaders(gl, VShaderSource, FShaderSource).get

    val modelMatrix = Mat4.create()
    val angle = 60.0f
    val tx = 0.5f
    modelMatrix.rotate(angle, Vec3.fromValues(0.0f, 0.0f, 1.0f))
    modelMatrix.translate(Vec3.fromValues(tx, 0.0f, 0.0f))

    val u_ModelMatrix = gl.getUniformLocation(program, "u_ModelMatrix")

    gl.uniformMatrix4fv(u_ModelMatrix, false, modelMatrix.elements)

  }

}
