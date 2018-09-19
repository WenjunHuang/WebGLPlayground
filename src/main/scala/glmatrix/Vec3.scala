package glmatrix

class Vec3 private[glmatrix](private[glmatrix] val rawArray: raw.Vec3Array)

object Vec3 {
  def fromValues(x: Float, y: Float, z: Float): Vec3 = {
    new Vec3(raw.vec3.fromValues(x, y, z))
  }
}