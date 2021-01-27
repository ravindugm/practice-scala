package lectures.part01basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(3))
  println(str.substring(0, 5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // Prepending = +:, Appending = :+
  println(str.reverse)
  println(str.take(5))

  // Scala specific: String Interpolators

  // S-Interpolators
  val name = "Ravindu"
  val age = 24
  val greeting = s"Hello, My name is $name and I am $age years old."
  val anotherGreeting = s"Hello, My name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-Interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute" // %2.2f = Float number format: Means two characters total minimum and two decimals precision
  println(myth)
  // F-Interpolators can check the type correctness

  // Raw-Interpolators
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
