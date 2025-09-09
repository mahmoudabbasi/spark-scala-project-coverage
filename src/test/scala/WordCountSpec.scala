package ir.test

import org.apache.spark.sql.SparkSession
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite


class WordCountSpec extends AnyFunSuite with BeforeAndAfterAll{


  val spark: SparkSession = SparkSession.builder()
    .appName("WordCountTest")
    .master("local[*]")
    .getOrCreate()

  test("countWords should count words correctly") {
    val input = Seq("hello world", "hello spark")
    val result = WordCount.countWords(spark, input).collect().toSet

    assert(result.contains(("hello", 2)))
    assert(result.contains(("world", 1)))
    assert(result.contains(("spark", 1)))
  }

  test("isEmptyInput should detect empty input correctly") {
    assert(WordCount.isEmptyInput(Seq()))
    assert(!WordCount.isEmptyInput(Seq("data")))
  }


  test("TextProcessor normalizeText should clean and lowercase") {
    val input = Seq("Hello, WORLD!", "Spark-Scala")
    val result = TextProcessor.normalizeText(spark, input).collect()
    assert(result.contains("hello"))
    assert(result.contains("world"))
    assert(result.contains("sparkscala"))
  }

  test("Utils topNWords should return top N words") {
    val data = Seq(("a", 10), ("b", 5), ("c", 8))
    val top2 = Utils.topNWords(data, 2)
    assert(top2 == Seq(("a", 10), ("c", 8)))
  }


}
