package com.JsonData;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student
{
    public String name;
    public int age;

    Student(String n,int a)
    {
        name = n;
        age = a;
    }
}

public class ListToJSONArray
{
    public static void main(String[] args)
    {
        try
        {
            List<Student> list = new ArrayList<>();

            list.add(new Student("Aayush",21));
            list.add(new Student("Ravi",30));
            list.add(new Student("Neha",25));

            ObjectMapper mapper = new ObjectMapper();

            String jsonArray = mapper.writeValueAsString(list);

            System.out.println(jsonArray);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
