package exercises

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is the list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElement: String

  // Polymorphic class
  override def toString: String = "[" + printElement + "]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElement: String = " "
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B>:A](element: B): MyList[B] = new Cons(element, this)

  def printElement: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElement
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}

/*
  Scala offers class-based inheritance
    - access modifiers: private, protected, default(none = public)
    - need to pass in constructor arguments to parent class
 */