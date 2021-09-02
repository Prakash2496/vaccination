package com.hangarww.vaccination.utility;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MongoUtils {
    private MongoUtils(){}
    public static String loadResource(String name) {
        return new Scanner(MongoUtils.class.getResourceAsStream(name), StandardCharsets.UTF_8.name()).useDelimiter("\\Z").next();
    }

}
