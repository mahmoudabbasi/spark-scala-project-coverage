package ir.test

import org.apache.spark.sql.SparkSession
import org.scalatest.funsuite.AnyFunSuite


class WordCountSpec extends AnyFunSuite {


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


}
