package com.radish.thinking.unit14;

import javax.lang.model.type.NullType;
import java.util.List;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test {
        public static void test(Robot r) {
            if (r instanceof NullType) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
