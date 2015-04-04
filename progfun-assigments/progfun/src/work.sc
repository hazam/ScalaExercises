object work {
	import week4._
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	def print(e : Expr) : String = {
	  e match {
	    case Number(n) => n.toString
	    case Sum(e1, e2) => print(e1) + " + " + print(e2)
	    case Var(x) => x
	    case Prod(e1, e2) => {
	    	e1 match {
	    		case Sum(_, _) => "("+print(e1) +") * "+print(e2)
	    		case _ => print(e1) +" * "+print(e2)
	    	}
	    }
	  }
	}                                         //> print: (e: week4.Expr)String
	
	print( Sum( Prod( Number(2), Var("x")), Var("y")) )
                                                  //> res0: String = 2 * x + y
	print( Prod( Sum( Number(2), Var("x")), Var("y")) )
                                                  //> res1: String = (2 + x) * y
}