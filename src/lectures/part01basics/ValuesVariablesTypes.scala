package lectures.part01basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // Vals are Immutable - can not be reassigned
  // Vars are Mutable

  // Compiler Can Infer Types
  // val x = 42

  // Using semicolon ; is not necessary in Scala. Can use semicolon if write multiple expressions in one line
  // val aString: String = "Hello"; val anotherString = "Good Bye"

  val aString: String = "Hello"
  val anotherString = "Good Bye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 1995
  val aLong: Long = 28800505055255L
  val aFloat: Float = 3.0f
  val aDouble: Double = 5.26

  // Variables
  var aVariable: Int = 4
  aVariable = 5 // Side Effects - allows to see what programs are doing
}
