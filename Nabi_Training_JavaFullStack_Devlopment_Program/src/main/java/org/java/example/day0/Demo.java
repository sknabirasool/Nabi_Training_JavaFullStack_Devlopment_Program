package org.java.example.day0;

public class Demo {
    // Method to validate age for voting
    public void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("User is not eligible for voting");
        } else {
            System.out.println("User is eligible for voting");
        }
    }
    public static void main(String[] args) {
        Demo validator = new Demo();
        int[] ages = {16, 20, 30, 15}; // Sample ages
            for (int age : ages) {
            try {
                System.out.println("Checking eligibility for age: " + age);
                validator.validateAge(age);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

