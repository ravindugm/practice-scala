package lectures.part02oop

import playground.{PrinceCharming, Cinderella => Princess}

// import playground._ // Can use when everything in the package playground imported by the single name

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {
  // Package members are accessible by their simple name
  val writer = new Writer("Ravindu", "Miyuranga", 1995)

  // Import the package
  val princess = new Princess
  //  val princess = new playground.Cinderella // playground.Cinderella = Fully qualified name

  // Package are in hierarchy
  // Matching folder structure

  // Package Object - hold standalone methods/constants
  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  val price = new PrinceCharming

  // 1. Use FQ names
  val date = new Date
  val sqlDate = new sqlDate(2021, 2, 1)

  // 2. Use aliasing

  // Default import
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
