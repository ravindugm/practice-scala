package lectures.part02oop

object OOBasics extends App {
  val person = new Person("Ravindu", 25)
  println(person.age)
  println(person.x)

  person.greeting("Miyu")
  person.greeting()
}

// Constructor
class Person(name: String, val age: Int = 0) {
  // Body
  val x = 2

  println(1 + 3)

  // Method
  def greeting(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading - Defining methods with a same name, but with different signatures
  def greeting(): Unit = println(s"Hi, I am $name")

  // Multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

// Class parameters are NOT FIELDS