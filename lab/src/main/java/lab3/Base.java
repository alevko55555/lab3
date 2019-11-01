package lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class Base {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: lab3.Base <input path> <output path>");
            System.exit(-1);
        }
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        final Broadcast<Map<String, String>> broadcast = sc.broadcast(
                sc.textFile(args[0])
                        .zipWithIndex()
                        .filter(elem -> elem._2() != 0).map(elem -> new AirportParser(elem._1()))
                        .mapToPair(split ->
                                new Tuple2<>(
                                        split.getIdAirport(),
                                        split.getInfoAirport()
                                )
                        )
                        .collectAsMap()
        );
        sc.textFile(args[1])
                .zipWithIndex()
                .filter(elem->elem._2() != 0)
                .map(elem -> new FlightParser(elem._1()))
                .mapToPair(split ->
                        new Tuple2<>(
                                new Tuple2<>(
                                        split.getIdAirportFrom(),
                                        split.getIdAirportDest()
                                ),
                                new Tuple2<>(
                                        split.getDelay(),
                                        split.getFlagCanceled()
                                )
                        )
                )
                .aggregateByKey(
                        new FlightSerializable(),
                        (stored, flight) -> stored.append(Long.parseLong(flight._1()), flight._2()),
                        FlightSerializable::append
                )
                .map(tuple ->
                        new Tuple2<>(
                                new Tuple2<>(
                                        broadcast.value().get(tuple._1()._1()),
                                        broadcast.value().get(tuple._1()._2())
                                ),
                                tuple._2()
                        )
                ).saveAsTextFile(args[2]);
    }
}

