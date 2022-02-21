package com.example.config;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class VotePortel {
    public static void main(String[] args) {
        Student s1=new Student("ram",25,Arrays.asList("0128788996","9798788996"));
        Student s2=new Student("asfg",34,Arrays.asList("9798788996","9798788996"));
        Student s3=new Student("sfju",21,Arrays.asList("0128788996","9798788996"));
        Student s4=new Student("anju",16,Arrays.asList("9798788996","9798788996"));
        Student s5=new Student("raju",17,Arrays.asList("9798788996","0128788996"));
        Student s6=new Student("annu",12,Arrays.asList("9798788996","9798788996"));
        Student s7=new Student("anjali",17,Arrays.asList("0128788996","9798788996"));

        List<Student> students= Arrays.asList(s1,s2,s3,s4,s5,s6);

       /* for (Student s:students) {
            List<String> contactNo = s.getContactNo();
            for (String st:contactNo) {
                for (int i=0;i<contactNo.size();i++)
                {
                    String a=contactNo.get(i);
                    if(a.startsWith("012"))
                    {
                        System.out.println("Student belongs to noida "+s.getName());
                    }
                }
            }*/
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
        List<Integer> squaresList1 = numbers.stream().map( i -> i*i).sorted().collect(Collectors.toList());
        System.out.println(squaresList1);






       // List<String> string=Arrays.asList("");

        } 
    }

   /*     List<String> collect = contactNo.stream().filter(x -> x.startsWith("012_")).collect(Collectors.toList());
         System.out.println(collect);
*/


        //List<Student> collect = students.stream().filter(x -> x.getContactNo().startsWith("012_")).collect(Collectors.toList());



