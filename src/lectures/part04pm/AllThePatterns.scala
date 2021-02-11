package lectures.part04pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  // 1 - Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "A number"
    case "Scala" => "The Scala"
    case true => "The True"
    case AllThePatterns => "A singleton object"
  }
  println(constants)

  // 2 - Match anything
  // 2.1 - Wildcard
  val matchAnything = x match {
    case _ => "Scala is a perfect language"
  }
  println(matchAnything)

  // 2.2 - Variable
  val matchVariable = x match {
    case something => s"I have found $something"
  }
  println(matchVariable)

  // 3 - Tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) => "Numbers"
    case (something, 2) => s"I have found $something belongs to Tuple"
  }
  println(matchTuple)

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, amountPhones)) => s"I have $amountPhones mobile phones"
  }
  println(matchNestedTuple)
  // Patterns matches can be Nested!

  // 4 - Case classes - Constructor pattern
  /* val aList: MyList[Int] = Cons(1, Cons(2, Empty))
   val matchAList = aList match {
     case Empty =>
     case Cons(head, Cons(subhead, subtail)) =>
   }*/

  // 5 - List pattern
  val aStandardList = List(1, 2, 3, 95)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "Test01" // Extractor - advanced
    case List(1, _*) => "Test02" // List of arbitrary length - advanced
    case 1 :: List(_) => "Test03" // Infix pattern
    case List(1, 2, 3) :+ 95 => "Test04" // Infix pattern
  }
  println(standardListMatching)

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "This is a List" // Explicit type specifier
    case _ => "This is not a List"
  }
  println(unknownMatch)

  // 7 - Name Binding
  /*val  nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // Name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => // Name binding inside nested patterns
  }*/

  // 8 - Multi - Patterns
  /*val multiPattern = aList match {
    case Empty | Cons(0, _) => // Compound pattern (Multi - pattern)
  }*/

  // 9 - If guards
  /*val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }*/

  /*
    Exercise
   */

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "A list of Strings"
    case listOfIntegers: List[Int] => "A list if Numbers"
    case _ => "Nothing"
  }
  println(numbersMatch)
}
