package playground

object ScalaPlayground extends App {
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(3, 4))

  val stringToInt: String => Int = new Function[String, Int] {
    override def apply(str: String): Int = str.toInt
  }

  println(stringToInt("5") + 6)

  def concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concat("John ", "Doe"))

  def testFun: Int => Int => Int = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(testFun(5)(6))

  val supperAdder = (x: Int) => (y: Int) => x + y
  println(supperAdder(5)(7))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val increment10 = nTimesBetter(plusOne, 10)
  println(increment10(1))

  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  val adder2 = superAdder(3)
  println(adder2(10))
  println(superAdder(5)(7))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // ===== Generics =====
  class MyList[+A]{
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???

  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // generic object
  object MyList{
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val covariantList: CovariantList[Animal] = new CovariantList[Cat]

  // Invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // Contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  /*class Car
  val newCage = new Cage(new Car)*/


}
