package ir.test

import org.apache.spark.sql.{Dataset, SparkSession}

object WordCount {

  def countWords(spark: SparkSession, input: Seq[String]): Dataset[(String, Int)] = {
    import spark.implicits._
    input
      .flatMap(_.split("\\s+"))
      .filter(_.nonEmpty)
      .groupBy(identity)
      .mapValues(_.size)
      .toSeq
      .toDS()
  }

  def isEmptyInput(input: Seq[String]): Boolean = {
    input.isEmpty || input.forall(_.trim.isEmpty)
  }


}
