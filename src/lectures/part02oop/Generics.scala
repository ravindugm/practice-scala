package lectures.part02oop

object Generics extends App {

  // Type A is a Generic type
  // Object can not be type parameterized
  class MyList[+A] {
    // Use the type A
    def add[B >: A](element: B): MyList[B] = ??? // Type B be a super-type of A and Type B instead and return MyList of B
    /*
      A = Cat
      B = Dog = Animal
      If add Animal into a list of Cat then that return into a MyList of Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]
  val emptyListOfString = MyList.empty[String]

  // Variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE - List of Cat can extends List of Animal
  class CovariantList[+A] // +A means this is a Covariant List
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // Replacing list of Animal with the list of Cat, because Cat are Animal
  // animalList.add(new Dog) Can we add new Dog to animal list => Return a list of Animal

  // INVARIANCE - INVARIANCE classes can not substituted one for another
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // CONTRAVARIANCE
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal] // Replacing list of Cat with the list of Animal

  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal] // Trainer of Animal can trainer of Cat

  // Bounded types - Allow to use Generic classes for either sub-class of different type or super class of different type
  class Cage[A <: Animal](animal: A) // class Cage only accept type-parameter A which are sub-types of Animal
  val cage = new Cage(new Dog) // Evaluate something that which is an Animal

  class Car

  // Generic type needs proper bounded-type
  //  val newCage = new Cage(new Car)

  class Carnivore[A >: Animal] // Carnivore accept something which is a super-type of Animal

  // Expand MyList to be Generic

  /*
     Generic means use the same code on many (potentially unrelated) types
     Its works for classes and traits
     [+A] - Yes(Covariant)
     [A] - No(Invariant) - Default
     [-A] - Hell No!(Contravariant)
   */

}
