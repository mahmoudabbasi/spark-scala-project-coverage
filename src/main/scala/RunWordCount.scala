package ir.test

import org.apache.spark.sql.SparkSession

object RunWordCount {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("WordCountExample")
      .master("local[*]") // اجرا روی همه هسته‌های CPU محلی
      .getOrCreate()

    val input = Seq(
      "hello world",
      "hello spark",
      "spark streaming"
    )

    val result = WordCount.countWords(spark, input)
    result.show() // نمایش خروجی روی ترمینال

    // تست تابع isEmptyInput
    println("Is empty input? " + WordCount.isEmptyInput(Seq()))
    println("Is empty input? " + WordCount.isEmptyInput(Seq("hello")))

    spark.stop()


  }

}
