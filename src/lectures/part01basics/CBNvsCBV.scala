package lectures.part01basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by name: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34)
  printFirst(34, infinite())
}
