package playground

object ScalaPlayground extends App {
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(3, 4))

  val stringToInt: String => Int = new Function[String, Int] {
    override def apply(str: String): Int = str.toInt
  }

  println(stringToInt("5") + 6)

  def concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concat("John ", "Doe"))

  def testFun: Int => Int => Int = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(testFun(5)(6))

  val supperAdder = (x: Int) => (y: Int) => x + y
  println(supperAdder(5)(7))
}
