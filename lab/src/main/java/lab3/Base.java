package lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;

import java.util.Map;

public class Base {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.err.println("Usage: lab3.Base <input path> <output path>");
            System.exit(-1);
        }
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        final Broadcast<Map<Long, String>> broadcast = sc.broadcast(
              sc.textFile(args[0])
                      .zipWithIndex()
                      .filter(elem->elem._2() != 0).map(elem-> new BaseParser(elem._1()))
                      .mapToPair()
        );
    }

