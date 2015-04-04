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
  }
  val lev = new Level1 {

  }                                               //> lev  : streams.test.Level1 = streams.test$$anonfun$main$1$$anon$1@2b1de6a0

  lev.pathsFromStart.take(4).toSet                //> res0: scala.collection.immutable.Set[(streams.test.lev.Block, List[streams.t
                                                  //| est.lev.Move])] = Set((Block(Pos(1,1),Pos(1,1)),List()), (Block(Pos(1,2),Pos
                                                  //| (1,3)),List(Right)), (Block(Pos(1,4),Pos(1,4)),List(Right, Right)), (Block(P
                                                  //| os(1,1),Pos(1,1)),List(Left, Right)))
  lev.solution                                    //> res1: List[streams.test.lev.Move] = List()
}