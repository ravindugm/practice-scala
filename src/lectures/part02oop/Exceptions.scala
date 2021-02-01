package lectures.part02oop

object Exceptions extends App {
  val x: String = null
  //  println(x.length)
  //  this ^^ will crash with a NullPointerException

  // 1. Throwing exceptions876

  // val aWeirdValue: String = throw new NullPointerException

  // Throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 25

  val potentialFail = try {
    // Code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 30
  } finally {
    // Code that will get executed no matter what
    // Optional
    // Does not influence the return type of this expression
    // Use Finally only for side effects
    println("Finally")
  }

  println(potentialFail)

  // 3. How to define your own Exceptions
  class MyException extends Exception

  val exception = new MyException

  // throw exception
  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverflowError
    3. PocketCalculator
       - add(x,y)
       - subtract(x,y)
       - multiply(x,y)
       - divide(x,y)

       Throw
       - OverflowException if add(x,y) exceeds Int.MAX_VALUE
       - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
       - MathCalculationException for division by 0
   */

  // OOM
  // val array = Array.ofDim(Int.MaxValue)

  // SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
