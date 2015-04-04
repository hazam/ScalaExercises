object work {
	import week4._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(330); 
  
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
	};System.out.println("""print: (e: week4.Expr)String""");$skip(55); val res$0 = 
	
	print( Sum( Prod( Number(2), Var("x")), Var("y")) );System.out.println("""res0: String = """ + $show(res$0));$skip(53); val res$1 = 
	print( Prod( Sum( Number(2), Var("x")), Var("y")) );System.out.println("""res1: String = """ + $show(res$1))}
}
