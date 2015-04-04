package streams

object test {
  trait Level1 extends GameDef with Solver with StringParserTerrain {
    val level =
      """ooo-------
      |oSoooo----
      |----------
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(275); 
  val lev = new Level1 {

  };System.out.println("""lev  : streams.test.Level1 = """ + $show(lev ));$skip(36); val res$0 = 

  lev.pathsFromStart.take(4).toSet;System.out.println("""res0: scala.collection.immutable.Set[(streams.test.lev.Block, List[streams.test.lev.Move])] = """ + $show(res$0));$skip(15); val res$1 = 
  lev.solution;System.out.println("""res1: List[streams.test.lev.Move] = """ + $show(res$1))}
}
