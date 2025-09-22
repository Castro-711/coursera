package recfun

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

  case class Row(i: Int, cols: List[Int])

  def pascal(c: Int, r: Int): Int = {
    def isAnEdge(c: Int, r: Int): Boolean = if c == 0 || c == r then true else false

    def calculateNonEdge(c: Int, r: Int): ((Int, Int), (Int, Int)) = ((c - 1, r - 1), (c, r - 1))

    def triangle(_r: Int, _c: Int, t: List[Row]): Int = {
      (_r, _c) match {
        case (row, col) if row == 0 => triangle(_r + 1, 0, t :+ Row(_r, List(1)))
        case (row, col) if col == 0 => triangle(_r, _c + 1, t :+ Row(_r, List(1)))
        case (row, col) if row == col => triangle(_r + 1, 0, t.updated(row, Row(row, t.last.cols :+ 1)))
        case (row, col) if _r != r && _c != c =>
          println(s"r: $row, c: $col, triangle: $t")
          val prevRow: Row = t.find(myRow => myRow.i == row - 1).getOrElse(Row(100, List.empty))
          val colsToCalculate = prevRow.cols(col) + prevRow.cols(col - 1)
          triangle(_r, _c + 1, t.updated(row, Row(row, t.last.cols :+ colsToCalculate)))
        case (_, _) => t(r).cols(c)
      }
    }

    triangle(0, 0, List.empty[Row])
      // row length will always be the row number + 1
      /**
          [r=0, c=0]
          [r=1, c=0][r=1, c=1]
          [r=2, c=0][r=2, c=1][r=2, c=2]
          [r=3, c=0][r=3, c=1][r=3, c=2][r=3, c=3]
          [r=4, c=0][r=4, c=1][r=4, c=2][r=4, c=3][r=4, c=4]
          [r=5, c=0][r=5, c=1][r=5, c=2][r=5, c=3][r=5, c=4][r=5, c=5]
          [r=6, c=0][r=6, c=1][r=6, c=2][r=6, c=3][r=6, c=4][r=6, c=5][r=6, c=6]
          [r=7, c=0][r=7, c=1][r=7, c=2][r=7, c=3][r=7, c=4][r=7, c=5][r=7, c=6][r=7, c=7]
          [r=8, c=0][r=8, c=1][r=8, c=2][r=8, c=3][r=8, c=4][r=8, c=5][r=8, c=6][r=8, c=7][r=8, c=8]
          [r=9, c=0][r=9, c=1][r=9, c=2][r=9, c=3][r=9, c=4][r=9, c=5][r=9, c=6][r=9, c=7][r=9, c=8][r=9, c=9]
          [r=10, c=0][r=10, c=1][r=10, c=2][r=10, c=3][r=10, c=4][r=10, c=5][r=10, c=6][r=10, c=7][r=10, c=8][r=10, c=9][r=10, c=10]
        */

        /**
          0:        1
          1:       1 1
          2:      1 2 1
          3:     1 3 3 1
          4:    1 4 6 4 1
          */

      // def pascalHelper(_c: Int, _r: Int, triangle: Array[Array[Int]] = Array.empty[Array[Int]]): Array[Array[Int]] = {
      //   println(s"_c[$_c], _r[$_r], triangle[${triangle.array}], c[$c], r[$r]")
      //   if (_c == 3 && _r == 3)
      //     triangle
      //   else if (_c == 0 && _c < _r)
      //     triangle(_c)(_r) = 1
      //     println(s"tri => $triangle")
      //     pascalHelper(_c + 1, _r, triangle)
      //   else if (_c == _r)
      //     triangle(_c)(_r) = 1
      //     println(s"tri ==> $triangle")
      //     pascalHelper(_c + 1, 0, triangle)
      //   else 
      //     println(s"in the else clause")
      //     if (_c > 1 && _r > 1)
      //       triangle(_c)(_r) = triangle(_c)(_r - 1) + triangle(_c - 1)(_r - 1)
      //     println(triangle) 
      //     pascalHelper(_c + 1, _r, triangle)
      // }
      // val arr = Array(Array(0), Array(0, 0), Array(0, 0, 0))
      // pascalHelper(0, 0, arr)(c)(r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
