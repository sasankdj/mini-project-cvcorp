package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

// import p1.project;

public class hand {
    public static Scanner sc = new Scanner(System.in);

    static String mainfile(int n) {
        switch (n) {
            case 1:
                return "java topics/javaTopics.txt";

            case 2:
                return "python topics/pythonTopics.txt";
            case 3:
                return "java topics/javaTopics.txt";
            default:
                return "";
        }
    }

    static void printer(String file) {
        try {

            BufferedReader bf = new BufferedReader(new FileReader(file));

            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);

            }
        } catch (Exception e) {

        }
    }

    public static String subfile(int m, int n) {
        String s;
        if (m == 1) {

            s = "java topics/" + n + ".txt";
        } else if (m == 2) {
            s = "python topics/" + n + ".txt";

        } else {
            s = "aptitude topics/" + n + ".txt";

        }
        // return s;

        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";

        System.out.print(
                CYAN +
                        " __          ___           _                     _         \n" +
                        " \\ \\        / / |         | |                   | |        \n" +
                        "  \\ \\  /\\  / /| |__   __ _| |_   _ __   _____  _| |_       \n" +
                        "   \\ \\/  \\/ / | '_ \\ / _` | __| | '_ \\ / _ \\ \\/ / __|      \n" +
                        "    \\  /\\  /  | | | | (_| | |_  | | | |  __/>  <| |_   _ _ \n" +
                        "     \\/  \\/   |_| |_|\\__,_|\\__| |_| |_|\\___/_/\\_\\\\__| (_|_)\n" +
                        RESET);
        return s;
    }

    public static String topics(int m, int n) {
        String s;
        if (m == 1) {

            s = "java topics/" + n + "_.txt";
        } else if (m == 2) {
            s = "python topics/" + n + "_.txt";

        } else {
            s = "aptitude topics/" + n + "_.txt";

        }
        return s;
    }

    public static void lessons(int m, int n, String t) {
        try {

            BufferedReader bf = new BufferedReader(new FileReader(topics(m, n)));

            String s, c;
            c = "2." + Integer.toString(n);
            boolean print = false;
            while ((s = bf.readLine()) != null) {
                if (s.startsWith(t))
                    // System.out.println(s);
                    print = true;
                else if (print && s.matches("\\d+\\.\\d+.*")) {
                    break;
                }

                if (print) {
                    System.out.println(s);
                }

            }
        } catch (Exception e) {

        }
    }

    public static void subjectMenu() {
        project.intro();

        int c = sc.nextInt();
        // printer(mainfile(c)); // topics
        topicsPrinter(c);
        int sub = sc.nextInt();
        subTopicsPrinter(c, sub);
        sc.nextLine();
        String t = sc.nextLine();
        while (true) {

            lessons(c, sub, t);
            System.out.println("press enter to continue..");
            sc.nextLine();
            sc.nextLine();
            project.lmsMenu();
            int lms = Integer.parseInt(sc.next());
            if (lms == 1) {
                t = nextSubtopic(t);
            } else if (lms == 2) {
                sub++;
                subTopicsPrinter(c, sub);
                sc.nextLine();
            t = sc.nextLine();
            } else if (lms == 3) {
               QuizSystem.menu();

            } else if (lms == 4) {
                subjectMenu();
            } else
                // System.out.println("Invalid Input");
                break;
        }
    }

    public static String nextSubtopic(String t) {

        String[] parts = t.split("\\.");
        int topic = Integer.parseInt(parts[0]);
        int sub = Integer.parseInt(parts[1]);

        sub++; // move to next

        return topic + "." + sub;
    }

    public static void topicsPrinter(int c) {
        printer(mainfile(c)); // topics
    }

    public static void subTopicsPrinter(int c, int sub) {
        printer(subfile(c, sub)); // sub topics
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        subjectMenu();
        // chapterMenu();
    }
}
