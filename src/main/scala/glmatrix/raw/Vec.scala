package glmatrix.raw

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array

@js.native
trait Vec2Array extends Float32Array

@js.native
trait Vec3Array extends Float32Array

@js.native
trait Vec4Array extends Float32Array

@js.native
trait Vec2 extends js.Object {
  def create(): Vec2Array = js.native
}


@js.native
trait Vec4 extends js.Object {
  def create(): Vec4Array = js.native
}

@js.native
trait Vec3 extends js.Object {
  def create(): Vec3Array = js.native

  def fromValues(x: Float, y: Float, z: Float): Vec3Array = js.native

  def set(out: Vec3Array, x: Float, y: Float, z: Float): Vec3Array = js.native

  def clone(src: Vec3Array): Vec3Array = js.native

  def length(src: Vec3Array): Float = js.native

  def copy(dest: Vec3Array, src: Vec3Array): Vec3Array = js.native

  def add(dest: Vec3Array, first: Vec3Array, second: Vec3Array): Vec3Array = js.native

  def substract(dest: Vec3Array, first: Vec3Array, second: Vec3Array): Vec3Array = js.native

  def multiply(dest: Vec3Array, first: Vec3Array, second: Vec3Array): Vec3Array = js.native

  def devide(dest: Vec3Array, first: Vec3Array, second: Vec3Array): Vec3Array = js.native

  def ceil(dest: Vec3Array, first: Vec3Array): Vec3Array = js.native

  def floor(dest:Vec3Array,first:Vec3Array):Vec3Array = js.native

  def min(dest:Vec3Array,first:Vec3Array,second:Vec3Array):Vec3Array = js.native

}
