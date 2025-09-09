package ir.test

object Utils {

  def isEmpty(input: Seq[String]): Boolean = {
    input.isEmpty || input.forall(_.trim.isEmpty)
  }

  def topNWords(wordCounts: Seq[(String, Int)], n: Int): Seq[(String, Int)] = {
    wordCounts.sortBy(-_._2).take(n)
  }


}
