package org.java.example.day0;

public class MemoryDemo {

    public static void main(String[] args) {
        // Creating objects
        Person person1 = new Person("John");
        Person person2 = new Person("Doe");

        // Using the objects
        System.out.println(person1.getName());
        System.out.println(person2.getName());

        // Dereference objects
        person1 = null;
        person2 = null;

        // Requesting garbage collection
        System.gc();
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // This method is called by garbage collector when the object is being collected
    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being garbage collected");
        super.finalize();
    }
}

