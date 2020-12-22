package gg.arystoteles

import scala.io.StdIn

object Calculator {

  def calculateTaskResult(taskNumber: Int, pupils: Int): Map[Int, BigDecimal] = {
    val points: Map[Int, BigDecimal] = readTaskPoints(pupils)
    val sumResults: BigDecimal = sumTasksPoints(points)

    countDifficultFactor(taskNumber, pupils, sumResults)
    points
  }

  private def sumTasksPoints(results: Map[Int, BigDecimal]): BigDecimal = {
    results.values.foldLeft(BigDecimal(0.0))(_ + _)
  }

  private def readTaskPoints(pupils: Int): Map[Int, BigDecimal] = {
    (for (i <- 1 to pupils) yield {
      println(s"Wynik ucznia $i: ")
      (i, BigDecimal(StdIn.readDouble()))
    }).toMap
  }

  private def countDifficultFactor(taskNumber: Int, pupils: Int, sumResults: BigDecimal): Unit = {
    val result = BigDecimal((4 - 3 * (sumResults / pupils)).toDouble)
    println(s"Wspolczynnik trudnosci dla zadania $taskNumber: $result\n")
  }
}