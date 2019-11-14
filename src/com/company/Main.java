package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    Scanner key = new Scanner(System.in);

    private static ArrayList<Faculty> faculties = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Class> classes = new ArrayList<>();
    private static ArrayList<Enroll> enrollments = new ArrayList<>();
    private static ArrayList<Admin> Administrators = new ArrayList<>();


    public static void main(String[] args) {


        Faculty prof1 = new Faculty(0, "Dumbledore", "bossman@hogwarts.com", "password1");
        Faculty prof2 = new Faculty(1, "Snape", "snape@hogwarts.com", "password2");
        Faculty prof3 = new Faculty(2, "Hagrid", "giant@hogwarts.com", "password3");

        Collections.addAll(faculties, prof1, prof2, prof3);

        Student stud1 = new Student(0, "Harry", "h@hogwarts.com", "passwordh");
        Student stud2 = new Student(1, "Ron", "r@hogwarts.com", "passwordr");
        Student stud3 = new Student(2, "Neville", "n@hogwarts.com", "passwordn");

        Collections.addAll(students, stud1, stud2, stud3);

        Class class1 = new Class(0, "Defense Against the Dark Arts", "spells and stuff");
        Class class2 = new Class(1, "Potions", "potions and stuff");
        Class class3 = new Class(2, "Herbology", "plants and stuff");

        Collections.addAll(classes, class1, class2, class3);

        Enroll enroll1 = new Enroll(0, 0, "12/33/10");
        Enroll enroll2 = new Enroll(1, 1, "12/31/12");
        Enroll enroll3 = new Enroll(2, 2, "12/12/11");

        Collections.addAll(enrollments, enroll1, enroll2, enroll3);

        Admin admin = new Admin(0, "Tony", "tony@hogwarts.com", "password");

        Collections.addAll(Administrators, admin);


        System.out.println("Welcome to Hogwart's School System");
        // System.out.println("Would you like to login as a (f)aculty, (s)tudent, or (a)dmin?");

        checkLogin();

        String userInput;
        Scanner key = new Scanner(System.in);


        do {
            System.out.println("Options?\n" +
                    "\t[\"1\"] Add Student\n" +
                    "\t[\"2\"] Add Faculty\n" +
                    "\t[\"3\"] Edit Student\n" +
                    "\t[\"4\"] Edit Faculty\n" +
                    "\t[\"5\"] Add Class\n" +
                    "\t[\"6\"] Edit Class\n" +
                    "\t[\"7\"] Enroll Student\n" +
                    "\t[\"8\"] Hire a Faculty\n" +
                    "\t[\"9\"] View all information\n" +
                    "\t[\"q\"] To Quit\n" +
                    "Enter the number with your desired change:");

            userInput = key.nextLine();


            if (userInput.equalsIgnoreCase("1")) {
                addNewStudent();
                // showPersonDB();
            } else if (userInput.equalsIgnoreCase("2")) {
                addNewFaculty();
            } else if (userInput.equalsIgnoreCase("3")) {
                findStudent();
                editStudent();
            } else if (userInput.equalsIgnoreCase("4")) {
                findFaculty();
                editFaculty();
            } else if (userInput.equalsIgnoreCase("5")) {
                addClass();
            } else if (userInput.equalsIgnoreCase("6")) {
                findClass();
                editClass();
            } else if (userInput.equalsIgnoreCase("7")) {
                boolean bool = true;
                int cid = 0, pid = 0;
                do {
                    System.out.print("Which class are you linking?");
                    String s = key.nextLine();
                    for (Class cl : classes) {
                        if (s.equalsIgnoreCase(cl.getName())) {
                            bool = false;
                            cid = cl.getId();
                        }
                    }
                    if (bool) {
                        System.out.println("No such class exists.");
                    }
                } while (bool);
                bool = true;
                do {
                    System.out.print("Which student are you linking to this company?");
                    String name = key.nextLine();
                    for (Student student : students) {
                        if (name.equalsIgnoreCase(student.getName())) {
                            bool = false;
                            pid = student.getId();
                        }
                    }
                    if (bool) {
                        System.out.println("No such student exists.");
                    }
                } while (bool);
                enrollments.add(new Enroll(cid, pid, enrollments.size()));
            } else if (userInput.equalsIgnoreCase("8")) {
                addNewFaculty();
            } else if (userInput.equalsIgnoreCase("9")) {
                showText();
            } else if (userInput.equalsIgnoreCase("q")) {
                break;
            }


        } while (true);

    }

    private static void checkLogin() {

        while (true) {
            String email, pass, student, faculty;

            Scanner key = new Scanner(System.in);

            System.out.println("Would you like to login as a (f)aculty, (s)tudent, or (a)dmin?");

            String ans;
            ans = key.nextLine();

            if (ans.equalsIgnoreCase("a")) {
                System.out.println("Enter your email to login: ");

                email = key.nextLine();

                System.out.println("Enter your password: ");

                pass = key.next();

                if (email.equalsIgnoreCase("tony@hogwarts.com") && (pass.equalsIgnoreCase("password"))) {
                    System.out.println("Welcome Admin");
                    break;
                } else {
                    System.out.println("Invalid login");
                }
            }

            if (ans.equalsIgnoreCase("s")) {
                System.out.println("Enter your email to login: ");

                email = key.nextLine();

                System.out.println("Enter your password: ");

                pass = key.next();

                if (email.equalsIgnoreCase("harry@hogwarts.com") && (pass.equalsIgnoreCase("passwordh"))) {
                    System.out.println("Welcome Harry! 10 points from Gryffindor");
                    break;
                } else {
                    System.out.println("Invalid login");
                }
            }

            if (ans.equalsIgnoreCase("f")){
                    System.out.println("Enter your email to login: ");

                    email = key.nextLine();

                    System.out.println("Enter your password: ");

                    pass = key.next();

                    if (email.equalsIgnoreCase("bossman@hogwarts.com") && (pass.equalsIgnoreCase("password1"))) {
                        System.out.println("Welcome Head Master");
                        break;
                    }else if (email.equalsIgnoreCase("snape@hogwarts.com") && (pass.equalsIgnoreCase("password2"))) {
                        System.out.println("Welcome Professor Snape");
                        break;
                    }else{
                        System.out.println("Invalid login");
                    }
                }
            }
        }
//
//
//                if (ans.equalsIgnoreCase("f")){
//                    System.out.println("Enter your email to login: ");
//
//                    email = key.nextLine();
//
//                    System.out.println("Enter your password: ");
//
//                    pass = key.next();
//
//                    if (email.equalsIgnoreCase("bossman@hogwarts.com") && (pass.equalsIgnoreCase("password1"))) {
//                        System.out.println("Welcome Head Master");
//                        break;
//                    }else if (email.equalsIgnoreCase("snape@hogwarts.com") && (pass.equalsIgnoreCase("password2"))) {
//                        System.out.println("Welcome Professor Snape");
//                        break;
//                    }else{
//                        System.out.println("Invalid login");
//                    }
//                }
//            }
//            System.out.println("Enter your email to login: ");
//
//            email = key.nextLine();
//
//            System.out.println("Enter your password: ");
//
//            pass = key.next();
//
//            if (email.equalsIgnoreCase("tony@hogwarts.com") && (pass.equalsIgnoreCase("password"))) {
//                System.out.println("Welcome Admin");
//                break;
//            } else if (email.equalsIgnoreCase("bossman@hogwarts.com") && (pass.equalsIgnoreCase("password1"))) {
//                System.out.println("Welcome Head Master");
//                break;
//            }else if (email.equalsIgnoreCase("snape@hogwarts.com") && (pass.equalsIgnoreCase("password2"))) {
//                System.out.println("Welcome Professor Snape");
//                break;
//            }else if (email.equalsIgnoreCase("harry@hogwarts.com") && (pass.equalsIgnoreCase("passwordh"))){
//                System.out.println("Welcome Harry! 10 points from Gryffindor");}
//                else{
//                System.out.println("Invalid login");
//            }


    private static void showText() {
        for (Student s : students) {
            for (Enroll e : enrollments) {
                if (e.getStudentId() == s.getId()) {
                    for (Faculty f : faculties) {
                        if (f.getId() == e.getFacultyId()) {
                            System.out.println(s.getName() + ", " + f.getName());
                            System.out.println(e.getFacultyId() + ", " + e.getDateEnrolled() + "," + s.getId() + ", " + s.getName());
                        }
                    }
                }
            }
        }
    }


    private static void addNewStudent() {
        Scanner key = new Scanner(System.in);
        String name;
        String email;
        String password;
        System.out.print("Please enter the Student's name: ");
        name = key.nextLine();
        int id = students.size() + 1;
        System.out.println("Please enter the Student's email: ");
        email = key.nextLine();
        System.out.println("Please enter the Student's password: ");
        password = key.nextLine();
        students.add(new Student(id, name, email, password));
    }

    private static void addNewFaculty() {
        Scanner key = new Scanner(System.in);
        String name;
        String email;
        String password;
        System.out.print("Please enter the Faculty's name: ");
        name = key.nextLine();
        int id = faculties.size() + 1;
        System.out.println("Please enter the Faculty's email: ");
        email = key.nextLine();
        System.out.println("Please enter the Faculty's password: ");
        password = key.nextLine();
        faculties.add(new Faculty(id, name, email, password));
    }

    public static int findStudent() {

        Scanner key = new Scanner(System.in);

        boolean bool = true;
        int id = 0;
        do {
            System.out.print("Which Student ID will you be changing?");
            String s = key.nextLine();
            for (Student student : students) {
                if (s.equalsIgnoreCase(student.getName())) {
                    bool = false;
                    id = student.getId();
                }
            }
            if (bool) {
                System.out.println("No such person exists.");
            }
        } while (bool);
        return (int) id;
    }

    public static void editStudent() {

        Scanner key = new Scanner(System.in);

        String s = key.nextLine();

        if (s.equalsIgnoreCase("3")) {
            int i = findStudent();
            System.out.print("Enter new name: ");
            String n = key.nextLine();
            students.get(i).setName(n);
            System.out.println("Enter new email: ");
            String e = key.nextLine();
            students.get(i).setEmail(e);
            String p = key.nextLine();
            students.get(i).setPassword(p);
        }
    }

    public static int findFaculty() {
        Scanner key = new Scanner(System.in);

        boolean bool = true;
        int id = 0;
        do {
            System.out.print("Which Faculty ID will you be changing?");
            String s = key.nextLine();
            for (Faculty faculty : faculties) {
                if (s.equalsIgnoreCase(faculty.getName())) {
                    bool = false;
                    id = faculty.getId();
                }
            }
            if (bool) {
                System.out.println("No such faculty exists.");
            }
        } while (bool);
        return (int) id;
    }

    public static void editFaculty() {

        Scanner key = new Scanner(System.in);

        String s = key.nextLine();

        if (s.equalsIgnoreCase("4")) {
            int i = findFaculty();
            System.out.print("Enter new name: ");
            String n = key.nextLine();
            faculties.get(i).setName(n);
            System.out.println("Enter new email: ");
            String e = key.nextLine();
            faculties.get(i).setEmail(e);
            System.out.println("Enter new password");
            String p = key.nextLine();
            faculties.get(i).setPassword(p);
        }
    }

    public static void addClass() {
        Scanner key = new Scanner(System.in);

        String name;
        String description;
        System.out.print("Please enter the Class name you'd like to add: ");
        name = key.nextLine();
        int id = classes.size() + 1;
        System.out.println("Please enter the class description: ");
        description = key.nextLine();
        classes.add(new Class(id, name, description));
    }

    public static int findClass() {
        Scanner key = new Scanner(System.in);

        boolean bool = true;
        int id = 0;
        do {
            System.out.print("Which class ID will you be changing?");
            String s = key.nextLine();
            for (Class cl : classes) {
                if (s.equalsIgnoreCase(cl.getName())) {
                    bool = false;
                    id = cl.getId();
                }
            }
            if (bool) {
                System.out.println("No class exists.");
            }
        } while (bool);
        return (int) id;
    }

    public static void editClass() {
        Scanner key = new Scanner(System.in);

        String s = key.nextLine();

        if (s.equalsIgnoreCase("6")) {
            int i = findClass();
            System.out.print("Enter new name: ");
            String n = key.nextLine();
            classes.get(i).setName(n);
            System.out.println("Enter new description: ");
            String e = key.nextLine();
            classes.get(i).setDescription(e);

        }
    }
}
