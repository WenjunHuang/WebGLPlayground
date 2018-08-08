package glmatrix

class Mat4 private[glmatrix](array: raw.Mat4Array) {
  def elements = array

  def rotate(angle: Float, axis: Vec3): Mat4 = {
    raw.mat4.rotate(array, array, angle, axis.raw)
    this
  }

  def translate(tx: Vec3): Mat4 = {
    raw.mat4.translate(array, array, tx.raw)
    this
  }

}

object Mat4 {
  def create():Mat4 = {
    Mat4(raw.mat4.create())
  }

  def fromTranslation(v: Vec3): Mat4 = {
    Mat4(raw.mat4.fromTranslation(raw.mat4.create(), v.raw))
  }
}
