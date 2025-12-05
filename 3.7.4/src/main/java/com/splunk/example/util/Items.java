package com.splunk.example.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Items {

    private final static Random rand = new Random();

    public static String random(){
        return ITEMS.get(rand.nextInt(ITEMS.size()));
    }

    private final static List<String> ITEMS = Arrays.asList(
            "toy soldier", "magnet", "candy wrapper", "fishing hook", "roll of duct tape",
            "chair", "bread", "shoes", "matchbook", "pair of knitting needles", "paperclip",
            "package of glitter", "ladle", "hair clip", "whistle", "roll of duct tape",
            "pocketwatch", "fake flowers", "cork", "feather duster", "hand fan", "toilet paper tube",
            "shoe lace", "bag of popcorn", "check book", "toy soldier", "dog", "thread",
            "jar of pickles", "radio", "lemon", "chalk", "sheet of paper", "hair ribbon",
            "steak knife", "handheld game system", "banana", "street lights", "stick of incense",
            "shoes", "kitchen knife", "mouse pad", "pair of binoculars", "fishing hook", "acorn",
            "baseball hat", "rope", "towel", "box of Q-tips", "card"
    );
}
