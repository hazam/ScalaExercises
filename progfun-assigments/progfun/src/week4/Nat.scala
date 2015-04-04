package week4

//Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true
  override def predecessor: Nothing = throw new NoSuchElementException("Zero.predecessor")
  override def +(that: Nat): Nat = that
  override def -(that: Nat): Nat = if (that.isZero) this else throw new NoSuchElementException("Zero.predecessor")
}

class Succ(val n: Nat) extends Nat {
  override def isZero: Boolean = false
  override def predecessor: Nat = n
  
  override def +(that: Nat): Nat = {
    if (that.isZero) this
    else successor + that.predecessor
  }
  
  override def -(that: Nat): Nat = 
    if (that.isZero) this
    else if (this.isZero) throw new NoSuchElementException("Zero.predecessor")
    else predecessor - that.predecessor
}