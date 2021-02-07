package lectures.part03fp

import java.util
import scala.util.Random

object Sequences extends App {

  // Seq
  /*
    A (very) general interface for data structures that
     - have a well defined order
     - can be indexed

    Supports various operations
     - apply, iterator, length, reverse for indexing and iterating
     - concatenation, appending, prepending
     - a lot of others: grouping, sorting, zipping, searching, slicing
   */

  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello")) // Do something 10 times

  // Lists
  /*
    A LinearSeq immutable linked list
     - head, tail, isEmpty methods are fast: O(1)
     - most operations are O(n): length, reverse

    Sealed - has two subtypes:
     - object Nil (empty)
     - class ::
   */

  val aList = List(1, 2, 3)
  val prepended = 42 +: aList
  println(prepended)
  val prepended2 = 85 :: aList
  println(prepended2)
  val appended = aList :+ 56
  println(appended)
  val fullList = 65 +: aList :+ 23
  println(fullList)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|-"))

  // Arrays
  /*
    The equivalent of simple Java arrays
     - can be manually constructed with predefined lengths
     - can be mutated(updated in place)
     - aew interoperable with Java's T[] arrays
     - indexing is fast
   */

  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // Syntax sugar for number.update(2, 0)
  println(numbers.mkString(" "))

  // array and seq
  val numberSeq: Seq[Int] = numbers // Implicit conversion
  println(numberSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // Vectors vs Lists

  val maxRun = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r  = Random
    val times = for {
      it <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRun
  }

  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  // Advantage of List - keep reference to tail
  // Disadvantage of List - updating an element in the middle takes long time
  println(getWriteTime(numberList))

  // Advantage of Vector - depth of the tree is small
  // Disadvantage of Vector - needs to replace an entire 32-element chunk
  println(getWriteTime(numberVector))

}
