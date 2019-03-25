package com.company;

import java.util.*;

class User {
    String name;
    int age;

    User(String n, int a) {
        name = n;
        age = a;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        //вопрос 7
/*        class Comp implements Comparator<User>{
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        }
        TreeSet<User> tree = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        //вопрос 9
        LinkedList<String> a = new LinkedList<>();

        a.add("spring");

        a.add(0, "n");
        a.add(0, "b");
        a.add(0, "jyr");
        Collections.sort(a);
        System.out.println(Collections.binarySearch(a, "spring"));
        //вопрос 12
        TreeMap<String, String> pets = new TreeMap<>();
        SortedMap<String, String> mondayPets = pets.subMap("A", "I");*/
        TreeMap<String, TreeMap<String, Integer>> clients = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String info = "";
        //цикл формирования ассоциативного массива
        while (scanner.hasNext()){
            info = scanner.nextLine();
            if(info.equals("exit")){
                break;
            }
            String infoArray[] = info.split(" ");
            String name = infoArray[0];
            String purshase = infoArray[1];
            Integer count = Integer.parseInt(infoArray[2]);

            if(!clients.containsKey(name)){
                clients.put(name, new TreeMap<String, Integer>());
            }
            TreeMap<String, Integer> temp = clients.get(name);
            if(!temp.containsKey(purshase)){
                temp.put(purshase, count);
            }
            else {
                Integer oldCount = temp.get(purshase);
                temp.put(purshase, oldCount + count);
            }
        }
        //вывод массива по требованиям
        for (Map.Entry<String, TreeMap<String, Integer>> entry: clients.entrySet()){
            System.out.println(entry.getKey() + ":");
            TreeMap<String, Integer> treeValue = entry.getValue();
            for (Map.Entry<String, Integer> valueEntry: treeValue.entrySet()){
                System.out.println(valueEntry.getKey() + " " + valueEntry.getValue());
            }
        }
    }
}
