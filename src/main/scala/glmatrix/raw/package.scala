package glmatrix

import scala.scalajs.js

package object raw {
  val mat2: raw.Mat2 = js.Dynamic.global.mat2.asInstanceOf[raw.Mat2]
  val mat4: raw.Mat4 = js.Dynamic.global.mat4.asInstanceOf[raw.Mat4]

  val vec2: Vec2 = js.Dynamic.global.vec2.asInstanceOf[Vec2]
  val vec3: raw.Vec3 = js.Dynamic.global.vec3.asInstanceOf[raw.Vec3]
}
