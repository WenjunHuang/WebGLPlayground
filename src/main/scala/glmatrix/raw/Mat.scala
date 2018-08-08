package glmatrix.raw

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array

@js.native
trait Mat2Array extends Float32Array

@js.native
trait Mat2 extends js.Object {
  def create(): Mat2Array = js.native

  def fromValues(m00: Float, m01: Float, m10: Float, m11: Float): Mat2Array = js.native

  def clone(array: Mat2Array): Mat2Array = js.native

  def copy(out: Mat2Array, src: Mat2Array): Mat2Array = js.native

  def identity(out: Mat2Array): Mat2Array = js.native

  def set(out: Mat2Array, m00: Float, m01: Float, m10: Float, m11: Float): Mat2Array = js.native

  def transpose(out: Mat2Array, src: Mat2Array): Mat2Array = js.native

  def invert(out: Mat2Array, src: Mat2Array): Mat2Array = js.native

  def adjoint(out: Mat2Array, src: Mat2Array): Mat2Array = js.native
}

@js.native
trait Mat4Array extends Float32Array

@js.native
trait Mat4 extends js.Object {
  def create(): Mat4Array = js.native

  def fromRotation(out: Mat4Array, rad: Float, axis: Vec3Array): Mat4Array = js.native

  def fromTranslation(out: Mat4Array, v: Vec3Array): Mat4Array = js.native

  def rotate(out: Mat4Array, src: Mat4Array, rad: Float, axis: Vec3Array) = js.native

  def translate(out:Mat4Array,src:Mat4Array,v:Vec3Array):Mat4Array = js.native
}

