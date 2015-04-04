package week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](the_value : T, the_tail: List[T]) extends List[T] {

  val a_head : T = the_value
  val a_tail : List[T] = the_tail

  def isEmpty = false

  override def head: T = this.a_head
  
  override def tail: List[T] = this.a_tail
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head");
  def tail: Nothing = throw new NoSuchElementException("Nil.tail");
}

object List {
  //List(1,2) - List.apply(1,2)
  def apply[T](x1: T, x2 : T) : List[T] = new Cons(x1, new Cons(x2, new Nil))  
  def apply[T]() = new Nil
}