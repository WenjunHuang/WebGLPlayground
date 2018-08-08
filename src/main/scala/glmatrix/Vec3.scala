package glmatrix

import glmatrix.raw

case class Vec3 private[glmatrix](raw: raw.Vec3Array) {
}

object Vec3 {
  def fromValues(x: Float, y: Float, z: Float): Vec3 = {
    Vec3(raw.vec3.fromValues(x, y, z))
  }
}