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

  val phoneBook = Map(("Ravindu", 521), "Miyuranga" -> 855, "RAVINDU" -> 900).withDefaultValue(-1)
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

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900 ?
       * Careful with mapping keys

    2. Overly simplified social network based on maps
       Person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend

       - number of friends of a person
       - person with most friends
       - how many people have NO friends
       - if there is a social connection between two people (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAccumulator: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAccumulator
      else removeAux(friends.tail, unfriend(networkAccumulator, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  // Jim, Bob, Mary
  val people = add(add(add(empty, "Jim"), "Bob"), "Mary")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Bob", "Mary")
  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
  // network.filterKeys(k => network(k).isEmpty).size
  // network.filterKeys(k => network(k).size == 0).size
  // network.filter(pair => pair._2.isEmpty).size
  // network.count(_._2.isEmpty)
    network.count(pair => pair._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
