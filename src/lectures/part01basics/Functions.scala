package lectures.part01basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you need Loops, Use Recursion
  // In Recursion function must add the return type

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1 * 2  * 3 ... * n
    3. A Fibonacci function
       f(1) = 1
       f(2) = 2
       f(n) = f(n-1) + f(n - 2)
    4. Tests if a number is prime.
   */

  def greetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old 😀"

  println(greetingFunction("Ravindu", 25))

  def factorialFunction(num: Int): Int =
    if (num <= 0) 1
    else num * factorialFunction(num - 1)

  println(factorialFunction(3))

  // Fibonacci numbers are 1 1 2 3  5 8 13 21 ...
  def fibonacciFunction(n: Int): Int =
    if (n <= 2) 1
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)

  println(fibonacciFunction(5))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(13))
  println(isPrime(2020))
  println(isPrime(5 * 8))
}
