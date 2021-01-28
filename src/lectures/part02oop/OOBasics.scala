package lectures.part02oop

object OOBasics extends App {
  val person = new Person("Ravindu", 25)
  println(person.age)
  println(person.x)

  person.greeting("Miyu")
  person.greeting()

  val writer = new Writer("John", "Doe", 2000)
  writer.fullName

  val author = new Writer("Kumarathunga", "Munidasa", 1941)
  val imposter = new Writer("Kumarathunga", "Munidasa", 1941)
  val novel = new Novel("Kaliyuga", 1955, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

  counter.dec.print
  counter.dec.dec.dec.print
  counter.dec(10).print
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

/*
  Novel and a Writer

  Writer: first name, surname, year
    -method fullname

  Novel: name, year of release, author
    -authorAge
    -isWrittenBy (author)
    -copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surName: String, val birthYear: Int) {
  def fullName: String = firstName + " " + surName
}

class Novel(novelName: String, releaseYear: Int, author: Writer) {
  def authorAge: Int = releaseYear - author.birthYear

  def isWrittenBy(author: Writer) = author == this.author

  def releaseCopy(newYear: Int): Novel = new Novel(novelName, newYear, author)
}

/*
  Counter class
    -receives an int value
    -method current count
    -method to increment/decrement => new Counter
    -overload increment/decrement to receive an amount
 */

class Counter(val count: Int = 0) { // If parameter is return that Field we use val
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // Immutability

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}

// Class parameters are NOT FIELDS