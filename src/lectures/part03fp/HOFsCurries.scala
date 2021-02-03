package lectures.part03fp

object HOFsCurries extends App {
  // Higher Order Functions - Take functions as parameter or return function as result is called HOF

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // map, flatMap, filter in MyList

  // Function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // nTimesBetter(f,n) = x => f(f(f...(x)))
  // Increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = Increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // Curried Functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // Function with multiple parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}

/*
  Functional programming = working with functions
    - pass functions as parameters
    - return functions as results

  Higher Order Functions(HOFs)
   - def nTimesBetter(f: Int => Int, n: Int): Int => Int = ...

  Curring = functions with multiple parameters list
   - def curriedFormatter(a: Int, b: Int)(c: String): String
 */
