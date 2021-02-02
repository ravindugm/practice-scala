package lectures.part03fp

object AnonymousFunctions extends App {

  /*val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }*/

  // Anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // val doubler: Int => Int = (x: Int) => x * 2
  // val doubler: Int => Int = x => x * 2

  // Multiple parameters in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // No parameters
  val justDoSomething: () => Int = () => 3

  // Careful
  println(justDoSomething) // Function itself
  println(justDoSomething())

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactical sugar
  val niceIncrementer: Int => Int = _ + 1 // Equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // Equivalent to (a, b) => a + b

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
