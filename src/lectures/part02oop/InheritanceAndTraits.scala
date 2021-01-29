package lectures.part02oop

object InheritanceAndTraits extends App {

  // Scala has single class Inheritance
  // Private - Only accessible within its class only
  // Protected - Only accessible within its class and subclasses
  // Scala by default haven't `public` access modifiers
  // Override is works for methods, val and var

  class Animal {
    val creatureType = "Wild"

    def eat = println("Meat")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  // Type - 01
  class Dog extends Animal {
    override val creatureType = "Domestic"

    override def eat = println("Fried Rice")
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  // Type - 02
  class Parrot(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("Mango")
    }
  }

  val parrot = new Parrot("African")
  parrot.eat
  println(parrot.creatureType)

  // Type - 03
  class Rabbit(rabbitType: String) extends Animal {
    override val creatureType = rabbitType
  }

  val rabbit = new Rabbit("White Rabbit")
  println(rabbit.creatureType)

  // Type Substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Parrot("K9")
  unknownAnimal.eat

  // Overriding vs Overloading
  /*
    Overriding - Supplying different implementations in derived classes
    Overloading - Supplying multiple methods with different signatures but with the same name in the same class
   */

  // Super - Reference a method or a field from parent class

  // Preventing Overrides
  /*
    1. Use final on member - final keyword is prevent override methods
    2. Use final on the entire class
    3. Sealed the class - extend classes in this file only and prevent extension in other files
   */
}
