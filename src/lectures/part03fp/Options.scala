package lectures.part03fp

import scala.util.Random

object Options extends App {

  /*
    An Option is a wrapper for a value that might be present or not
    Option mean possible absent of a value
    Option has two case classes
    - Some wraps a concrete value
    - None is a singleton for absent values
   */

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // Options use to deal with unsafe APIs
  // WORK with unsafe API
  def unsafeMethod(): String = null

  /*
    val result = Some(unsafeMethod()) - WRONG
    val result = Some(null) - WRONG
  */

  val result = Option(unsafeMethod())
  println(result)

  // Chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe API
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe - Do not use

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.map(x => x * 3))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions
  /*
    Exercise
   */

  val config: Map[String, String] = Map(
    // Fetched from elsewhere
    "host" -> "192.168.8.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // Connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // Try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")

  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)

     return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
    if (c != null)
      return c.connect

    return null
   */
  val connectionStatus = connection.map(c => c.connect)

  // if (connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
    if (connectionStatus != null)
      println(connectionStatus)
   */
  connectionStatus.foreach(println)

  // Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehension
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
  /*
    Giving a host that obtain from config.get("host")
    Giving a port that obtain from config.get("port")
    Giving a connection that obtain from Connection(host, port)
    Assuming host, port and connection are not null then give connection.connect
   */

  /*
    Can use Options for,
     - avoid runtime crash due to NPEs (NullPointerExceptions)
     - avoid an endless amount of null-related assertions

    ** If method return null, use Options **
   */
}
