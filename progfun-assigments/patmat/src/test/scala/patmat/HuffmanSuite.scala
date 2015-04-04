package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
	val charList = List('a','b','a','c','c','d','c')
	val leafList = List( ('a', 2),('b', 0), ('y', 7))
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }
  
  test("times") {
    new TestTrees {
    	val the_c = Huffman.times(charList).find(a => a._1 == 'c');
    	assert(the_c.get._2 === 3)
    }
  }
  
  test("makeOrderedLeafList") {
    new TestTrees {
    	val the_c = Huffman.makeOrderedLeafList(leafList)
    	assert(the_c.head.char === 'b')
    	assert(the_c.head.weight === 0)
    	
    	assert(the_c.last.char === 'y')
    	assert(the_c.last.weight === 7)
    }    
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("combine of some more list") {
    val leaflist = List(Leaf('t', 2), Leaf('x', 4), Leaf('v', 7))
    assert(combine(leaflist) === List(
        Fork(Leaf('t',2),Leaf('x',4),List('t', 'x'),6), Leaf('v', 7)))
  }

  test("combine of some complex list") {
    val leaflist = List( 
        Fork(Leaf('t',2),Leaf('x',4),List('t', 'x'),6),
        Leaf('v', 7))
    assert(combine(leaflist) === List(Fork(
        Fork(Leaf('t',2),Leaf('x',4),List('t', 'x'),6),
        Leaf('v',7),
        List('t', 'x', 'v'),13)) )
  }

  test("until the end of some complex list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val combinedUntil = until(singleton,combine)(leaflist)
    assert(combinedUntil.size == 1)
    assert(until(singleton,combine)(leaflist) === List
    (
        Fork(
            Fork(
                Leaf('e',1),
                Leaf('t',2),
                List('e', 't'),3),
            Leaf('x',4),
            List('e', 't', 'x'),7
        )
    ))
  }

  test("encode simple") {
    new TestTrees {
      assert(encode(t1)("a".toList) == List(0) )
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode huffmanestcool") {
    new TestTrees {
      val huff = "huffmanestcool".toList;
      val encod = encode(Huffman.frenchCode)(huff)
      assert( encod ===  Huffman.secret)
    }
  }

  test("build") {
	  val table = Huffman.convert(Huffman.frenchCode)
	  assert(table.nonEmpty)
  }
  
  test("quick decode") {
    new TestTrees {
      val huff = "huffmanestcool".toList;
      val encod = encode(Huffman.frenchCode)(huff)
      assert( encod ===  Huffman.secret)
      val quick = quickEncode(Huffman.frenchCode)(huff)
      assert( quick ===  encod)
    }
  }

  test("quick anything") {
    new TestTrees {
      val huff = "asdas".toList;
      val encod = encode(Huffman.frenchCode)(huff)
      val quick = quickEncode(Huffman.frenchCode)(huff)
      assert( quick ===  encod)
    }
  }
}
