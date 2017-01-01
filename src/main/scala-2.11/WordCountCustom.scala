import org.apache.spark.{SparkConf, SparkContext}
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
  * Created by abbasi on 12/28/16.
  */
object WordCountCustom {




  def main(args: Array[String]): Unit = {
    val logFile = "hdfs://192.168.48.128:9000/input_dir"

//    val sc = new SparkContext("local", "Simple App", "E://spark-0.9.1")//,
    val sc = new SparkContext("local", "Simple App")

    val logDataCount = sc.textFile(logFile)
    println("Count :"+logDataCount.count() +"first record :"+ logDataCount.first())
    val logData = sc.textFile(logFile).cache()
    val start = new Date()
    val numTHEs = logData.filter(line => line.contains("USERNAME_OR_PASSWORD_IS_INVALID")).count()
    val numTHEsa = logData.filter(line => line.contains("(camel-1)")).count()
    val numTHEsb = logData.filter(line => line.contains("b")).count()
    val findlog = logData.map(x=>x.split(" ").slice(0,3))

    val end = new Date()
    println("Lines with the: %s".format(numTHEs) + "   camel-1 with the: %s".format(numTHEsa) + "   Lines with the: %s".format(numTHEsb))
    println(end.getTime() - start.getTime)
  }




}
