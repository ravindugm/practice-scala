package lectures.part03fp

object WhatsAFunction extends App {
  // Dream: Use functions as first class elements
  // Problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Function types = Function[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("5") + 3)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1. A function which takes 2 strings and concatenates them
    2. Transform the MYPredicate and MyTransformer into function types
    3. Define a function which takes an int and return another function which takes an int and return an int
        - What's the type of this function
        - How to do it
   */

  def concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concat("Ravindu ", "Miyuranga"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder2 = superAdder(2)
  println(adder2(4))
  println(superAdder(3)(4)) // Curried Function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}

/*
  Pass the function as parameters
  Use functions as values
  Function traits, up to 22 parameters
  Syntactical sugar function types
 */