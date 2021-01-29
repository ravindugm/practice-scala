package lectures.part02oop

import sun.security.krb5.internal.PAEncTSEnc

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Objects can have values(val),  variables(var) and method definitions
  // To define a class level definition Scala use objects
  // Pattern that named classes and objects using same name in the same scope is called Companions

  /*
    Scala doesn't have "static" values/methods
    Scala objects
      - are in their own class
      - are the only instance
      - singleton pattern in one line

    Scala companions
      - Scala classes and object can stay in same scope
      - can access each other's private members
   */

  object Person { // type + its only instance
    // "static"/"class"  - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // Factory Method - It gives some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // Instance-level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton Instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person(mary, john)

  /*
    Scala Applications = Scala object with
    def main(args: Array[String]): Unit
   */
}
