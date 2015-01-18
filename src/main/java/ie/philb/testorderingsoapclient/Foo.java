/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient;

/**
 *
 * @author philb
 */
class Foo {

    long var1 = 0_100_267_760;	// ok

    long var6 = 0x1_0000_10;	// ok
    long var7 = 100__12_12; 	// ok 

    String name;

    public static void main(String[] args) {
        Foo f = new Foo();
        f.name = "";
    }

    public double subtractNumbers(byte arg1, int arg2, int arg3) {
        double sum = arg1 + arg2 + arg3;
        return sum;
    }
}

class Course {

    void enroll(long duration) {
        System.out.println("long");
    }

    void enroll(int duration) {
        System.out.println("int");
    }

    void enroll(String s) {
        System.out.println("String");

    }

    void enroll(Object o) {
        System.out.println("Object");
    }

    public static void main(String args[]) {
        Course course = new Course();
        char c = 10;
        course.enroll(c);
        course.enroll("Object");
    }
}
