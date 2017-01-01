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
  * Created by root on 12/28/16.
  */
object WordCountCustom1 {

    def main(args: Array[String]) {

        val conf = new SparkConf().setMaster("local[1]")
          .setAppName("GetEmployee")
          .set("spark.executor.memory", "1g")

         val sc = new SparkContext(conf)

        println("Hello, Scala!")
        val rdd = sc.parallelize(Seq("foo", "bar", "baz"))
        val mapped_rdd = rdd.map(term => term.reverse)
        mapped_rdd.foreach(println)

        mapped_rdd.take(2).foreach(println)


      }

  }
