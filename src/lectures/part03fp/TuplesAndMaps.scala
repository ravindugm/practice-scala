package lectures.part03fp

object TuplesAndMaps extends App {

  // Tuples = Finite ordered 'Lists'
  val aTuple = new Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)
  // Tuples can group 22 elements of different types
  val aTuple2 = Tuple2(2, "Hello, Scala")
  val aTuple3 = (2, "Hello Scala")

  println(aTuple)
  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "Goodbye Java")) // (2, Goodbye Java)
  println(aTuple.swap) // ("Hello Scala", 2)
  println(aTuple.toString()) // (2, Hello, Scala)

  // Maps - keys -> values
  // Maps are collection that use associate things with other things
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Ravindu", 521), "Miyuranga" -> 855).withDefaultValue(-1)
  // a -> b is sugar for (a,b)
  println(phoneBook)

  // Map Operations
  println(phoneBook.contains("Ravindu")) // true
  println(phoneBook("Miyuranga")) // 855
  println(phoneBook("Jim"))
  // If error occurs can throw an exception or add withDefaultValue to Map

  // Add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // Functional on Maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("R")))

  // mapValues
  println(phoneBook.mapValues(number => number * 10))
  println(newPhoneBook.mapValues(number => "0112-" + number))

  // conversion to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))


}
