package lectures.part02oop

object MethodNotation extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, My name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Titanic")
  println(mary.likes("Titanic"))
  println(mary likes "Titanic") // Equivalent
  // Infix notation = Operator notation (Syntactic Sugar)

  // Operators in Scala
  val tom = new Person("Tom", "Godzilla")
  println(mary + tom)
  println(tom + mary)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All Operators are Methods in Scala
  // Akka actors have ! ?

  // Prefix notation
  val x = -1 // Equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  // println(mary isAlive) // Postfix notation is only available to method without parameters

  // Apply
  println(mary.apply())
  println(mary()) // Equivalent
}
