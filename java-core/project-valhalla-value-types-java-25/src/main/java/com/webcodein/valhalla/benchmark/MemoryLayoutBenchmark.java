package com.webcodein.valhalla.benchmark;

import com.webcodein.valhalla.Point;
import com.webcodein.valhalla.StandardPoint;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MemoryLayoutBenchmark {

    private Point[] valueArray = new Point[1_000_000];
    private StandardPoint[] objectArray = new StandardPoint[1_000_000];

    @Setup
    public void setup() {
        for (int i = 0; i < 1_000_000; i++) {
            valueArray[i] = new Point(i, i);
            objectArray[i] = new StandardPoint(i, i);
        }
    }

    @Benchmark
    public long benchmarkValueTypes() {
        long sum = 0;
        for (Point p : valueArray) {
            sum += p.getX();
        }
        return sum;
    }

    @Benchmark
    public long benchmarkStandardObjects() {
        long sum = 0;
        for (StandardPoint p : objectArray) {
            sum += p.getX();
        }
        return sum;
    }
}
