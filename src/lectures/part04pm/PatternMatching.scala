package lectures.part04pm

import scala.util.Random

object PatternMatching extends App {

  // Switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The One"
    case 2 => "Double or nothing"
    case 3 => "Third time is the charm"
    case _ => "Something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, My name is $n and I can't drink in Sri Lanka"
    case Person(n, a) => s"Hi, My name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }
  println(greeting)

  /*
    1. Cases are matched in order
    2. What if no cases match? MatchError
    3. Type of pattern match expression? Unified type of all types in all the cases
    4. PM works really works with case classes
   */

  // Pattern Matching on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // Match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  val isEvenCond = if (x % 2 == 0) true else false // Bad practice
  val isEvenNormal = x % 2 == 0

  /*
    Exercise
    Simple function uses PM
    - Takes an Expression => Human readable form

    Sum(Number(2), Number(3)) => 2 + 3
    Sum(Sum(Number(2), Number(3)), Number(4)) => 2 + 3 + 4
    Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
    Prod(Sum(Number(2), Number(1)), Prod(Number(3), Number(4))) = (2 + 1) * 3 * 4
    Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
   */

  trait Expression
  case class Number(n: Int) extends Expression
  case class Sum(e1: Expression, e2: Expression) extends Expression
  case class Prod(e1: Expression, e2: Expression) extends Expression

  def show(exp: Expression): String = exp match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(expr: Expression) = expr match {
        case Prod(_, _) => show(expr)
        case Number(_) => show(expr)
        case _ => "(" + show(expr) + ")"
      }

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }

  }
  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Prod(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))


}
