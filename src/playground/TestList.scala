/*
package playground

abstract class TestList[+A] {

  def head: A
  def tail: TestList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): TestList[B]
  def printElement: String
  override def toString: String = "[" + printElement + "]"

  def map[B](transformer: MyTransformer[A, B]): TestList[B]
  def flatMap[B](transformer: MyTransformer[A, TestList[B]]): TestList[B]
  def filter(predicate: MyPredicate[A]): TestList[A]


}

object Empty extends TestList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: TestList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): TestList[B] = new Cons(element, Empty)
  def printElement: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): TestList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, TestList[B]]): TestList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): TestList[Nothing] = Empty
}

class Cons[+A](h: A, t: TestList[A]) extends TestList[A]{
  def head: A = h
  def tail: TestList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): TestList[B] = new Cons(element, this)
  def printElement: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElement


}

trait MyPredicate[-T]{
  def test(element: T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(element: A): B
}

object RunList extends App{
  val listOfIntegers: TestList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfStrings: TestList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
*/
