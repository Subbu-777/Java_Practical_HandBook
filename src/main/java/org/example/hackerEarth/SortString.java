package org.example.hackerEarth;

import java.util.*;
/*
Little Ashish got a lot of strings as his birthday gift. He does not mind getting so many strings for free; in fact, he loves them. But, on noticing all the strings he received as a gift, Little Ashish, who's also a snob and a bit OCD kind of a guy, realizes that he does not like the way in which the strings are arranged.

He likes his strings sorted, in a different kind of a way. He wants his strings to be sorted based on the count of characters present in the string. For instance, if the string is: "aaabbc", then the desired string would be: cbbaaa. In case where the count of two characters is same, then the lexicographically smaller one will be printed first. For instance: "aabbcc" then, the output will be: "aabbcc".

Input:
First line of input contains number of test cases T. Each test case contains a single string S.

Output:
For each test cases print the sorted string.

Constraints:
1<=T<=100
1<=|S|<=100

Note:
String contains only lowercase characters ['a' to 'z'].

Sample Input
3
aabbccdd
aabcc
hackerearth

Sample Output
aabbccdd
baacc
cktaaeehhrr

 */

public class SortString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer no = Integer.parseInt(s.nextLine());                 // Reading input from STDIN
        while (no-- > 0)
            sort(s.nextLine());
    }
    public static void sort(String name) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else
                map.put(character, 1);
        }
        // System.out.println(map);

        ArrayList<Map.Entry<Character, Integer>> sets = new ArrayList<>(map.entrySet());
        Collections.sort(sets, new Comparator<Map.Entry<Character, Integer>>() {
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return (o1.getValue()
                                == (o2.getValue()))
                                ? o1.getKey() - o2.getKey()
                                : o1.getValue() - o2.getValue();
                    }
                }

        );
        for (Map.Entry<Character, Integer> entry : sets) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey());
            }
        }
        System.out.println("");
    }


}
