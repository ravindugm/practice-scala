package lectures.part02oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields
  val ravindu = new Person("Ravindu", 25)
  println(ravindu.name)

  // 2. Sensible toString
  // println(instance) = println(instance.toString) // sysntactic suger
  println(ravindu.toString)
  println(ravindu)

  // 3. Equals and hashCode implemented out of the box
  val ravindu2 = new Person("Ravindu", 25)
  println(ravindu == ravindu2)

  // 4. Case classes have handy copy method
  val ravindu3 = ravindu.copy(age = 30)
  println(ravindu3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  // 6. Case classes are serializable - When dealing with distributed systems case classes can send its instances through the network in between JVM
  // Akka

  // 7. Case classes have extractor patters = Case classes can be used in pattern matching

  case object UnitedKingdom { // Case object don't get companion objects because its have own objects
    def name: String = "The UK of GB and NI"
  }

}
