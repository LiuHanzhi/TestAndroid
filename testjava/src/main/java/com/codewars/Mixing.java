package com.codewars;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * http://www.codewars.com/kata/5629db57620258aa9d000014/train/java
 * success
 */
public class Mixing {

    public static String mix(String s1, String s2) {
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        TreeMap<Character, Integer> map1 = get(s1);
        TreeMap<Character, Integer> map2 = get(s2);
        Set<KeyValue> result = new TreeSet<>();
        Iterator<Character> iterator1 = map1.keySet().iterator();
        while (iterator1.hasNext()) {
            Character key1 = iterator1.next();
            Integer value1 = map1.get(key1);
            if (map2.containsKey(key1)) {
                if (map2.get(key1) > value1) {
                    result.add(new KeyValue(key1, map2.get(key1), 2));
                } else if (map2.get(key1) < value1) {
                    result.add(new KeyValue(key1, value1, 3));
                } else if (value1 > 1) {
                    result.add(new KeyValue(key1, value1, 1));
                }
                map2.remove(key1);
            } else if (value1 > 1) {
                result.add(new KeyValue(key1, value1, 3));
            }
        }

        Iterator<Character> iterator2 = map2.keySet().iterator();
        while (iterator2.hasNext()) {
            Character key2 = iterator2.next();
            Integer value2 = map2.get(key2);
            if (value2 > 1) {
                result.add(new KeyValue(key2, value2, 2));
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        Iterator<KeyValue> iterator = result.iterator();
        while (iterator.hasNext()) {
            KeyValue key = iterator.next();
            switch (key.type) {
                case 1:
                    stringBuffer.append("=:");
                    break;
                case 3:
                    stringBuffer.append("1:");
                    break;
                case 2:
                    stringBuffer.append("2:");
                    break;
            }
            for (int i = 0; i < key.getValue(); i++) {
                stringBuffer.append(key.getKey());
            }
            if(iterator.hasNext()){
                stringBuffer.append("/");
            }
        }
        return stringBuffer.toString();
    }

    public static TreeMap<Character, Integer> get(String s) {
        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : chars) {
            if ((int) c >= 97 && (int) c <= 122) {
                map.put(c, map.get(c) != null ? map.get(c) + 1 : 1);
            }
        }
        return map;
    }

    public static class KeyValue implements Comparable {

        Character key;
        Integer value;
        int type;

        public KeyValue(Character key, Integer value, int type) {
            this.key = key;
            this.value = value;
            this.type = type;
        }

        public Character getKey() {
            return key;
        }

        public void setKey(Character key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            KeyValue o1 = (KeyValue) o;
            return (o1.value * 10000 + o1.type * 1000 - o1.key) - (value * 10000 + type * 1000 - key);
        }
    }

}