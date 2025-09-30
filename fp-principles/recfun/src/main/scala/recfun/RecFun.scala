package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */


  def pascal(c: Int, r: Int): Int = {
    case class Row(i: Int, cols: List[Int])
    
    @tailrec
    def triangle(_r: Int, _c: Int, t: List[Row]): Int = {
      (_r, _c) match {
        case (row, col) if row == 0 => triangle(_r + 1, 0, t :+ Row(_r, List(1)))
        case (row, col) if col == 0 => triangle(_r, _c + 1, t :+ Row(_r, List(1)))
        case (row, col) if _r <= r && _c <= c =>
          val prevRow: Row = t.find(myRow => myRow.i == row - 1).getOrElse(Row(100, List.empty))
          val colsToCalculate = prevRow.cols(col) + prevRow.cols(col - 1)
          triangle(_r, _c + 1, t.updated(row, Row(row, t.last.cols :+ colsToCalculate)))
        case (row, col) if row == col => triangle(_r + 1, 0, t.updated(row, Row(row, t.last.cols :+ 1)))
        case (_, _) => t(r).cols(c)
      }
    }

    triangle(0, 0, List.empty[Row])
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
