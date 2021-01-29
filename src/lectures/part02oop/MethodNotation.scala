package lectures.part02oop

object MethodNotation extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, My name is $name and I like $favoriteMovie"

    def apply(watchTime: Int) = s"$name watched $favoriteMovie $watchTime times"

    def learns(subject: String) = s"$name is leaning $subject"

    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Titanic")
  println(mary.likes("Titanic"))
  println(mary likes "Titanic") // Equivalent
  // Infix notation = Operator notation (Syntactic Sugar), for methods with one parameter

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

  /*
    1. Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnScala method, calls learns method with "Scala"
       Use it in postfix notation

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "The rockstar").apply())
  println(+mary.age)
  println(mary.learnsScala)
  println(mary learns ("Scala"))
  println(mary apply (3))
  println(mary apply 2)
}
