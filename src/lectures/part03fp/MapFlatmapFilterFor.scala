package lectures.part03fp

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // Print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")

  // Iteration
  // List("a1", "a2"... "d4")
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n)) // If have two loops do map and flatMap
  println(combinations)

  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  // Foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // Syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1. MyList supports for comprehensions?
       map(f: A => B) => MyList[B]
       filter(p: A => Boolean) => MyList[A]
       flatMap(f: A => MyList[B]) => MyList[B]
    2. A small collection of at most ONE element - Maybe[+T]
       - map, flatMap, filter
   */
}
