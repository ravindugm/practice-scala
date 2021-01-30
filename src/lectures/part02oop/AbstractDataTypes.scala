package lectures.part02oop

object AbstractDataTypes extends App {

  // Abstract
  // Abstract can have both abstract and non-abstract members
  abstract class Animal {
    val creatureType: String = "Wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Doberman"

    def eat: Unit = println("Fried Rice")

    // Override keyword is not mandatory for abstract members
  }

  // Traits - Ultimate abstract data type in Scala
  // Traits can inherited a long classes
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "Fresh Meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Crocodile"
    override val preferredMeal: String = "Fish"

    def eat: Unit = println("Meat")

    def eat(animal: Animal): Unit = println(s"I am a $creatureType and I'm eating ${animal.creatureType}")

  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  // Traits vs Abstract classes
  /*
    1. Traits do not have constructor parameter
    2. Multiple traits may be inherited by the same class
    3. Traits = Behavior, Abstract class = "thing"
       Ex: In here Animal describe Animal but Carnivore describe what the do
   */

}
