package funsets

object Main extends App {
  import patmat._

  val timesList = Huffman.times(List('a', 'b', 'a', 'c', 'c', 'd', 'c'));
  println(timesList)
  val leafList = Huffman.makeOrderedLeafList(timesList)
  println(leafList)
  println(Huffman.makeOrderedLeafList(List(('a', 2), ('b', 0), ('y', 7))).last)
  println(Huffman.decodedSecret)
  println(Huffman.encode(Huffman.frenchCode)(List('s')))
  println( Huffman.encode(Huffman.frenchCode)("huffmanestcool".toList) )
  
  println(Huffman.convert(Huffman.frenchCode))
}
