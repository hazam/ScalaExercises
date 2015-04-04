package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  def zeroToTen(x : Int) : Boolean = 
  	x == 0 || x == 2 || x == 4 || x == 6 || x == 8 || x == 11
  
  println("test" + FunSets.toString(map(zeroToTen, x => x + 1)) )
}
