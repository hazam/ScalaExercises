package forcomp

object test {
  import Anagrams._
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 2))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,2))
    val r = List(('r', 4))                        //> r  : List[(Char, Int)] = List((r,4))
    val rMap = Map().withDefaultValue(0) ++ r     //> rMap  : scala.collection.immutable.Map[Char,Int] = Map(r -> 4)
    lard.foldLeft(List[(Char, Int)]())(
    	(acc, pair : (Char, Int)) => {
    	val n = pair._2 - rMap.getOrElse(pair._1, 0)
    		if (n > 0) (pair._1 -> n) :: acc
    		else acc
    	}
   ).reverse                                      //> res0: List[(Char, Int)] = List((a,1), (d,1), (l,1))
   
   
   val sentence = List("Yes", "man")              //> sentence  : List[String] = List(Yes, man)
   sentenceAnagrams(sentence)                     //> res1: List[forcomp.Anagrams.Sentence] = List(List(my, en, as), List(my, as, 
                                                  //| en), List(my, sane), List(my, Sean), List(yes, man), List(en, my, as), List(
                                                  //| en, as, my), List(men, say), List(as, my, en), List(as, en, my), List(say, m
                                                  //| en), List(man, yes), List(sane, my), List(Sean, my))
}