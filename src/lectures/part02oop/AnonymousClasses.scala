package lectures.part02oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous Class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Fried Rice")
  }
  /*
    Equivalent with:

    class AnonymousClasses$$anon$1 extends Animal{
      override def eat: Unit = println("Fried Rice")
    }

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1

    println(funnyAnimal.getClass)
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help you?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  /*
    Anonymous Class works for traits and classes(Abstract or not)
    We can instantiate types and override fields or methods on the spot
    Rules
      - Pass in required constructor argument if needed
      - Implement all abstract fields/methods
   */
}
