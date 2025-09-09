package ir.test

import org.apache.spark.sql.{Dataset, SparkSession}

object TextProcessor {

  def normalizeText(spark: SparkSession, input: Seq[String]): Dataset[String] = {
    import spark.implicits._
    input.map(_.toLowerCase.replaceAll("[^\\p{L}\\p{Nd}]+", ""))
      .filter(_.nonEmpty)
      .toDS()
  }

  def splitWords(spark: SparkSession, input: Seq[String]): Dataset[String] = {
    import spark.implicits._
    input.flatMap(_.split("\\s+")).filter(_.nonEmpty).toDS()
  }


}
