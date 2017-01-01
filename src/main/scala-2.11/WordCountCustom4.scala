import org.apache.spark.SparkContext
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.Encoder
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark._
import org.apache.spark.SparkContext

// For implicit conversions from RDDs to DataFrames


/**
  * Created by abbasi on 1/1/17.
  */
object WordCountCustom4 {

  def main(args: Array[String]){




    val logFile = "hdfs://192.168.48.128:9000/output_dir3"

    val sc = new SparkContext("local", "Simple App")

    // Obtain SQLContext
    val sqlContext = new  SQLContext(sc)

    import sqlContext.implicits._


    val myFiles = sc.textFile(logFile)
    println(myFiles.count())
    val df=myFiles.map(x=>x.split(",")).map( x=> RecordChannel( x(0).toInt , x(1) , x(2) , x(3) , x(4)) )
    val dataframe =df.toDF()
    dataframe.show()
    val dataframefilter = dataframe.filter(dataframe("refAddress") like "%30%")
    dataframefilter.write.format("com.databricks.spark.csv").save("/data/filter.csv")
    //df.toDF()
    println(df.count())

  }

}
case class RecordChannel (id:Int , channelStatus :String , nameChannel :String , refAddress:String , code:String)


