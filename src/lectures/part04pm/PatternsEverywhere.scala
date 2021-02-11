package lectures.part04pm

object PatternsEverywhere extends App {

  // Big Idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "NPE"
    case _ => "Something else"
  }

  // Catches are actually Matches
  /*
    try {
      // code
    } catch (e) {
      e match {
        case e: RuntimeException => "Runtime"
        case npe: NullPointerException => "NPE"
        case _ => "Something else"
       }
     }
   */

  // Big Idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x
  println(evenOnes)

  // Generators are also based on Pattern Matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  println(filterTuples)
  // PMs works with case classes, :: operators, etc.

  // Big Idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)
  // Multiple values are based on Pattern Matching

  val head :: tail = list
  println(head)
  println(tail)

  // Big Idea #4 - NEW
  // Partial Function based on Pattern Matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "The one"
    case _ => "Something else"
  } // Partial function literal
  println(mappedList)

  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is Even"
      case 1 => "The One"
      case _ => "Something else"
    }
  }
  println(mappedList2)


}
