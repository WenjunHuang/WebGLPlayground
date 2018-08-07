package glmatrix

import scala.scalajs.js

@js.native
trait Mat2Array extends js.Object

@js.native
trait Mat2 extends js.Object {
  def create():Mat2Array = js.native
  def fromValues(m00:Float,m01:Float,m10:Float,m11:Float):Mat2Array = js.native
  def clone(array:Mat2Array):Mat2Array = js.native
  def copy(out:Mat2Array,src:Mat2Array):Mat2Array = js.native
  def identity(out:Mat2Array):Mat2Array = js.native
  def set(out:Mat2Array,m00:Float,m01:Float,m10:Float,m11:Float):Mat2Array = js.native
  def transpose(out:Mat2Array,src:Mat2Array):Mat2Array = js.native
  def invert(out:Mat2Array,src:Mat2Array):Mat2Array = js.native
  def adjoint(out:Mat2Array,src:Mat2Array):Mat2Array = js.native
}
