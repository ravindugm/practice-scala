package lectures.part03fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // Create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax sugar
  val anotherPotentialFailure = Try {
    // Code that might be throw
  }

  // Utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod())) // Try unsafeMethod(), if it fail orElse Try backupMethod()
  println(fallbackTry)

  // If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFallback)

  // map, flatMap, filter
  println(aSuccess.map(x => x * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(x => (x > 10)))
  // => for-comprehension

  /*
    Exercise
   */

  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // If you get the html page from the connection, print it to the console i.e call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // Shorthand version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension version
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /*
    try {
      connection = HttpService.getSafeConnection(host, port)
      try {
        page = connection.getSafe("/home")
        renderHTML(page)
      } catch (some other exception) {

      }
    } catch (exception) {

    }
   */

  /*
    Use Try to handle exceptions gracefully,
     - avoid runtime crashes due to uncaught exceptions
     - avoid an endless amount of try-catches

    A functional way of dealing with failure
     - map, flatMap, filter
     - orElse
     - others: fold, collect, toList, conversion to Options

    If you design a method to return a (some type)but may throw an exception, return a Try[that type] instead.
   */
}
