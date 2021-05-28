package com.jd.reflectex.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lizhihua03
 * @Description
 * @create 2021-05-25 16:19
 */

public class DiffTest {
    public static void main(String[] args) {
        List<String> listA = getList(

"8640095493,8640051294,8640037200,8640218628,8640222849,8640224798,8640023839,8640099154,8640227875,8640227975,8640073268,8640226391,8640227706,8640063627,8640216864,8640034886,8640074498,8640222977,8640095688,8640274197,8640274197,8640214496,8640220303,8640012418"


        );


        int size = listA.size();
        long count = listA.stream().distinct().count();
        List<String> listB = getList(
"8640216864,8640214496,8640074498,8640012418,8640227975,8640037200,8640220303,8640073268,8640226391,8640063627,8640227706,8640218628,8640099154,8640023839,8640224798,8640051294,8640095493,8640274197,8640222849,8640095688,8640222977,8640034886,8640227875"

        );
        List<String> diffrent = getDiffrent(listA, listB);

        List<String> lista =   getList("55312:4,59730:2,66246:1,78842:1,82788:3,84779:1,106979:3,160299:3,174298:3,177239:2,177452:4,177474:3,177941:2,178081:4,178084:3,179639:1,183858:7,187506:2,192201:4,192211:2,195704:1");

        List<String> listb =   getList("55312:3,59730:1,66246:1,78842:1,82788:3,84779:1,106979:3,160299:3,174298:3,177239:2,177452:4,177474:3,177941:2,178081:4,178084:3,179639:1,183858:7,187506:2,192201:4,192211:2,195704:1");

        getDiffrentMap(lista,listb);

    }

    public static List<String> getList(String string){
        return Arrays.stream(string.split(",")).collect(Collectors.toList());
    }


    public static List<String> getDiffrent(List<String> list1, List<String> list2) {
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
        List<String> diff = new ArrayList<String>();

        for (String string : list1) {
            map.put(string, -1);//A>B
        }

        for (String string : list2) {
            Integer cc = map.get(string);
            if (cc != null) {
                map.put(string, 0);//A==B
            }else {
                map.put(string, 1);//A<B
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                diff.add(entry.getKey());
            }
        }

        List<String> AxiaoyuB = map.entrySet().stream().filter(v -> v.getValue() == 1).map(v -> v.getKey()).collect(Collectors.toList());
        List<String> AdayuB = map.entrySet().stream().filter(v -> v.getValue() == -1).map(v -> v.getKey()).collect(Collectors.toList());

        System.out.println("A - B = " + AdayuB);
        System.out.println("B - A = " + AxiaoyuB);
        return diff;
    }

    private static void getDiffrentMap(List<String> listA, List<String> listB){
        Map<String,String> mapA = new HashMap<>();
        for (String s : listA) {
            mapA.put(s.split(":")[0],s.split(":")[1]);
        }

        for (String s : listB) {
            if(!s.split(":")[1].equals(mapA.get(s.split(":")[0]))){
                System.out.println("A = " + s.split(":")[0]+":"+mapA.get(s.split(":")[0] +" B = "+s));
            }
        }
    }
}
