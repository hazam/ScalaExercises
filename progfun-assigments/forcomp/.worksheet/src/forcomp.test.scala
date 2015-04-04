package forcomp

object test {
  import Anagrams._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(63); 
  
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 2));System.out.println("""lard  : List[(Char, Int)] = """ + $show(lard ));$skip(27); 
    val r = List(('r', 4));System.out.println("""r  : List[(Char, Int)] = """ + $show(r ));$skip(46); 
    val rMap = Map().withDefaultValue(0) ++ r;System.out.println("""rMap  : scala.collection.immutable.Map[Char,Int] = """ + $show(rMap ));$skip(200); val res$0 = 
    lard.foldLeft(List[(Char, Int)]())(
    	(acc, pair : (Char, Int)) => {
    	val n = pair._2 - rMap.getOrElse(pair._1, 0)
    		if (n > 0) (pair._1 -> n) :: acc
    		else acc
    	}
   ).reverse;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(45); 
   
   
   val sentence = List("Yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(30); val res$1 = 
   sentenceAnagrams(sentence);System.out.println("""res1: List[forcomp.Anagrams.Sentence] = """ + $show(res$1))}
}
