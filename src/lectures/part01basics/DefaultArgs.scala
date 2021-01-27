package lectures.part01basics

object DefaultArgs extends App {
  def tailRecFact(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else tailRecFact(n - 1, n * accumulator)

  val fact10 = tailRecFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving Picture")

  savePicture("bmp")
  savePicture(width = 800)

  /*
    1. Pass in every leading argument
    2. Name the arguments
   */

  // Can name the argument in different order
  savePicture(height = 600, width = 800, format = "bmp")

  def greetingFunction(name: String = "Batman", age: Int = 25): String =
    s"Hi, I'm $name and I'm $age years old."

  println(greetingFunction(name = "Hiru"))
  println(greetingFunction(name = "Ravindu", age = 20))
  println(greetingFunction(age = 18, name = "Poorna"))
}
