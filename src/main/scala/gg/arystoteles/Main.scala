package gg.arystoteles

import scala.io.StdIn

object Main extends App {

  println("Podaj liczbe zadan:")

  val allPoints: Seq[Map[Int, BigDecimal]] = for (taskNumber <- 1 to StdIn.readInt()) yield {
    println(s"Podaj liczbe uczniow dla zadania $taskNumber:")
    Calculator.calculateTaskResult(taskNumber, StdIn.readInt())
  }

  println("Suma wynikow dla poszczegolnych uczniow:")
  showResults(sumPupilTaskPoints)

  private def sumPupilTaskPoints: Map[Int, BigDecimal] = {
    allPoints
      .flatten
      .groupMapReduce(_._1)(_._2.asInstanceOf[BigDecimal])(_ + _)
  }

  private def showResults(results: Map[Int, BigDecimal]): Unit =
    results.foreach(res => println(s"Suma punktow dla ucznia ${res._1}: ${res._2}"))
}
