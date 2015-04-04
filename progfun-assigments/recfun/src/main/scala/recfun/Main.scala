package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0);
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if(c <= 0 || c >= r) 1
    else pascal(c, r-1) + pascal(c-1,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceAcc(n: Int, chars: List[Char]): Boolean =
      if (chars.isEmpty) n == 0
      else if (n < 0) false 
      else {
        val head = chars.head
        if (head == '(') balanceAcc(n + 1, chars.tail)
        else if (head == ')') balanceAcc(n - 1, chars.tail)
        else balanceAcc(n, chars.tail)
      }
    balanceAcc(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeAcc(acc:Int, moneyLeft: Int, coins: List[Int]): Int = {
      if (money == 0) acc
      else if (coins.isEmpty) acc
      else {
        val curValue : Int = coins.head;
        val newLeft = moneyLeft - curValue;
        if (newLeft == 0) {
          acc + 1
        } else if (newLeft < 0) {
          acc
        } else {    
          countChangeAcc(acc, newLeft, coins) + countChangeAcc(acc, moneyLeft, coins.tail);
        }
      }
    }

    countChangeAcc(0, money, coins.sorted);
  }
}