package com.splunk.example.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Names {

    private final static Random rand = new Random();

    public static String random(){
        return NAMES.get(rand.nextInt(NAMES.size()));
    }

    private final static List<String> NAMES = Arrays.asList(
            "jimbo", "brenton", "brenden", "nicholas", "jorden", "lea", "melina",
            "cali", "nash", "danica", "ali", "gillian", "camila", "maximillian", "kolby",
            "george", "melissa", "deven", "erik", "marques", "calvin", "philip", "jewel",
            "israel", "cash", "precious", "donna", "grayson", "sarah", "seamus", "jayden",
            "camryn", "jaylan", "kelton", "hadley", "nathan", "stephany", "austin", "antony",
            "mckinley", "hailee", "camille", "alex", "amara", "raegan", "isaac", "gunnar",
            "kendal", "asher", "kathryn", "lizeth"
    );
}
