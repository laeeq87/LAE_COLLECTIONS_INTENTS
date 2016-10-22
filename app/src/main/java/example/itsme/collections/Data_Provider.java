package example.itsme.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itsme on 9/29/2016.
 */
public class Data_Provider {
    private static List<course> data = new ArrayList<>();

    public static List<course> getData() {
        return data;
    }
    static {

        data.add(new course(1001,"Computer Science","computer science technologies",3));
        data.add(new course(1002,"Management Science","computer science technologies",3));
        data.add(new course(1003,"Economics Science","computer science technologies",3));
        data.add(new course(1004,"mathematics Science","computer science technologies",3));
        data.add(new course(1005,"Social Sciences","computer science technologies",3));

    }
}