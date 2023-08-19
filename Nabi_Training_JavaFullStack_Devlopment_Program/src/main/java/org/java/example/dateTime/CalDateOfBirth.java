package org.java.example.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalDateOfBirth {
    public static void main(String[] args) {

        int getCurrentYear= LocalDate.now().getYear();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your age is ex: 23 or 25");
        int age=scanner.nextInt();

        int dob=getCurrentYear-age;
        System.out.println("Your approximate year of birth Year  is"+dob);
    }
}
