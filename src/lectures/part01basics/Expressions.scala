package lectures.part01basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  //  + - * / & | ^ << >> >>> (Right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // Also work with -= *= /= Side Effect
  println(aVariable)
  // Changing a variable called side effect

  // Instruction (Tell the computer to 'DO') vs Expression (Something has a value or a type)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 7 else 3 // If Expression
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN

  // EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // Side Effects: println(), whiles, reassigning

  // Code Blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    println()
    if (z > 2) "Hello" else "Goodbye"
  }
  // Code Block is an Expression

  // Difference between "Hello World" vs println("Hello World") ?
  // Hello World a String and println("Hello World") is an  Expression

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 240 else 800
  }
  println(someOtherValue)


}
