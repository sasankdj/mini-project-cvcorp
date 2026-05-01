package p1;

import java.util.*;

class User {
    String username;
    String password;
    int score;
    boolean attempted;

    User(String u, String p) {
        username = u;
        password = p;
        score = 0;
        attempted = false;
    }
}

class Question {
    String question;
    String options;
    String correct;

    Question(String q, String o, String c) {
        question = q;
        options = o;
        correct = c;
    }
}

class Attempt {
    String answer = "";
    boolean visited = false;
    boolean marked = false;
    int timeSpent = 0;
}

public class QuizSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;

    // ---------------- SIGNUP ----------------
    static void signup() {
        System.out.print("Enter Username: ");
        String u = sc.next();

        System.out.print("Enter Password: ");
        String p = sc.next();

        users.add(new User(u, p));
        System.out.println("Signup Successful!\n");
    }

    // ---------------- LOGIN ----------------
    static boolean login() {
        System.out.print("Enter Username: ");
        String u = sc.next();

        System.out.print("Enter Password: ");
        String p = sc.next();

        for (User user : users) {
            if (user.username.equals(u) && user.password.equals(p)) {
                currentUser = user;
                System.out.println("Login Successful!\n");
                return true;
            }
        }

        System.out.println("Invalid Credentials!\n");
        return false;
    }

    // ---------------- OTP ----------------
    static boolean otp() {
        int otp = 1000 + (int) (Math.random() * 9000);
        System.out.println("OTP: " + otp);

        System.out.print("Enter OTP: ");
        int uotp = sc.nextInt();

        return otp == uotp;
    }

    static int askWithTimer(String question, String options, String correct) {

        try {
            System.out.println("\n" + question);

            if (!options.equals(""))
                System.out.println(options);

            System.out.println(" You have 5 seconds (answer quickly!)");

            long start = System.currentTimeMillis();

            String ans = sc.next(); // user can type immediately

            long end = System.currentTimeMillis();

            long timeTaken = (end - start) / 1000;

            if (timeTaken > 5) {
                System.out.println(" Time's up!");
                return 0;
            }

            if (ans.equalsIgnoreCase(correct)) {
                return 1;
            }

        } catch (Exception e) {
        }

        return 0;
    }


static String timedInput(int seconds) {

    final String[] input = {null};

    Thread t = new Thread(() -> {
        input[0] = sc.next();
    });

    t.start();

    for (int i = seconds; i > 0; i--) {
        System.out.print("\rAnswer within " + i + " sec: ");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        if (input[0] != null) {
            return input[0];
        }
    }

    System.out.println("\nTime up! Skipped.");
    return "0";
}
    // ---------------- QUIZ ----------------
   static void startQuiz() {

    if (currentUser.attempted) {
        System.out.println("You already attempted!\n");
        return;
    }

    if (!otp()) {
        System.out.println("Wrong OTP!\n");
        return;
    }

    ArrayList<Question> questions = new ArrayList<>();

    project.intro();
    int ch = sc.nextInt();

    if (ch == 1) {
        questions.add(new Question("What is Java?", "A.Language B.OS C.Browser D.Hardware", "A"));
        questions.add(new Question("Size of int?", "A.2 B.4 C.8 D.16", "B"));
        questions.add(new Question("OOP stands for?", "A.Object Oriented Programming B.Other", "A"));
    } else if (ch == 2) {
        questions.add(new Question("Who developed C?", "A.Dennis B.Gosling", "A"));
        questions.add(new Question("C is?", "A.Low B.Middle C.High", "B"));
        questions.add(new Question("Extension of C?", "A..java B..c C..py", "B"));
    } else if (ch == 3) {
        questions.add(new Question("2+2=?", "", "4"));
        questions.add(new Question("5*3=?", "", "15"));
        questions.add(new Question("10/2=?", "", "5"));
    }

    Collections.shuffle(questions);

    int n = questions.size();

    ArrayList<Attempt> attempts = new ArrayList<>();
    for (int i = 0; i < n; i++)
        attempts.add(new Attempt());

    int current = 0;

    int totalTime = n * 30; // total exam time (seconds)
    long examStart = System.currentTimeMillis();

    while (true) {

        //  GLOBAL TIMER
        int elapsed = (int)((System.currentTimeMillis() - examStart) / 1000);
        int remainingTotal = totalTime - elapsed;

        if (remainingTotal <= 0) {
            System.out.println("\nTime Over! Auto submitting...");
            break;
        }

        Question q = questions.get(current);
        Attempt a = attempts.get(current);

        int perLimit = 30;
        int remainingQ = perLimit - a.timeSpent;

        if (remainingQ <= 0) {
    System.out.println("\nTime over for this question!");

    if (current < n - 1) {
        current++;
    } else {
        System.out.println(" Last question reached. You can submit now.");
    }

    continue;
}

        a.visited = true;

        System.out.println("\n--------------------------------");
        System.out.println("Q" + (current + 1) + ": " + q.question);
        if (!q.options.equals("")) System.out.println(q.options);

        System.out.println(" Question Time Left: " + remainingQ + " sec");
        System.out.println(" Total Time Left: " + remainingTotal + " sec");
        if (remainingTotal <= 10) {
    System.out.println(" LAST " + remainingTotal + " SECONDS!");
}
        long start = System.currentTimeMillis();

        System.out.print("Answer (or 0 skip): ");
        String ans = sc.next();

        long end = System.currentTimeMillis();

        int spent = (int)((end - start) / 1000);
        a.timeSpent += spent;

        if (!ans.equals("0")) {
            a.answer = ans;
            a.marked = false;
        }

        // MENU
        System.out.println("\n1.Next 2.Previous 3.Jump 4.Mark 5.Palette 6.Submit");
        int choice = sc.nextInt();

        if (choice == 1) {
            if (current < n - 1) current++;
            else{
            
                System.out.println("Last question!");
                
            } 
                
        }

        else if (choice == 2) {
            if (current > 0) current--;
        }

        else if (choice == 3) {
            System.out.print("Enter question number: ");
            int jump = sc.nextInt();
            if (jump >= 1 && jump <= n) current = jump - 1;
        }

        else if (choice == 4) {
            a.marked = true;
        }

        else if (choice == 5) {
            showPalette(attempts);
        }

        else if (choice == 6) {
            break;
        }
    }

    currentUser.score = calculateScore(questions, attempts);
    currentUser.attempted = true;
}
    static void showPalette(ArrayList<Attempt> attempts) {
        System.out.println("\n--- Question Palette ---");

        for (int i = 0; i < attempts.size(); i++) {
            Attempt a = attempts.get(i);

            if (!a.visited)
                System.out.print("Q" + (i + 1) + "[NA] ");
            else if (a.marked)
                System.out.print("Q" + (i + 1) + "[M] ");
            else if (a.answer.equals(""))
                System.out.print("Q" + (i + 1) + "[N] ");
            else
                System.out.print("Q" + (i + 1) + "[A] ");
        }
        System.out.println();
    }

    static int calculateScore(ArrayList<Question> questions, ArrayList<Attempt> attempts) {

        int correct = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (attempts.get(i).answer.equalsIgnoreCase(questions.get(i).correct)) {
                correct++;
            }
        }

        return correct;
    }

    // ---------------- RESULT ----------------
    static void showResult() {

        int correct = currentUser.score;
        int total = 3;
        int wrong = total - correct;
        double percent = (correct * 100.0) / total;

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n+--------------------------------------+");
        System.out.println("|            QUIZ RESULT TABLE         |");
        System.out.println("+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Score", correct + "/" + total);
        System.out.println("+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Correct", GREEN + correct + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Wrong", RED + wrong + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Percentage", YELLOW + percent + "%" + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+" + RESET);

        if (percent >= 40) {
            System.out.println(GREEN + "\nPASS - Congratulations " + currentUser.username + "!" + RESET);
        } else {
            System.out.println(RED + "\nFAIL - Better Luck Next Time!" + RESET);
        }
         System.out.println("Press any key to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static void evaluate(ArrayList<Question> questions, ArrayList<Attempt> attempts) {

        int correct = 0, wrong = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (attempts.get(i).answer.equalsIgnoreCase(questions.get(i).correct)) {
                correct++;
            } else if (!attempts.get(i).answer.equals("")) {
                wrong++;
            }
        }

        int total = questions.size();
        double percent = (correct * 100.0) / total;

        currentUser.score = correct;

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n+--------------------------------------+");
        System.out.println("|            QUIZ RESULT TABLE         |");
        System.out.println("+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Score", correct + "/" + total);
        System.out.println("+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Correct", GREEN + correct + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Wrong", RED + wrong + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+");

        System.out.printf("| %-12s | %-21s |\n", "Percentage", YELLOW + percent + "%" + RESET);
        System.out.println(CYAN + "+--------------+-----------------------+" + RESET);

        if (percent >= 40) {
            System.out.println(GREEN + "\nPASS - Congratulations!" + RESET);
        } else {
            System.out.println(RED + "\nFAIL - Better Luck Next Time!" + RESET);
        }
        System.out.println("Press any key to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static void leaderboard() {

        String CYAN = "\u001B[36m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n+-------------------------------+");
        System.out.println("|          LEADERBOARD          |");
        System.out.println("+--------------+----------------+");
        System.out.printf("| %-12s | %-14s |\n", "Username", "Score");
        System.out.println("+--------------+----------------+");

        for (User u : users) {
            System.out.printf("| %-12s | %-14s |\n", u.username, GREEN + u.score + RESET);
        }

        System.out.println(CYAN + "+--------------+----------------+" + RESET);
         System.out.println("Press any key to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    // ---------------- MENU ----------------
    public static void menu() {
        while (true) {
            // System.out.println("\n1.Take Quiz 2.Result 3.Leaderboard 4.Notes 5.Logout");
            project.quizMenu();
            int ch = sc.nextInt();

            if (ch == 1)
                startQuiz();
            else if (ch == 2)
                showResult();
            else if (ch == 3)
                leaderboard();
            else if (ch == 4)
               hand.subjectMenu();
            else
                return;
        }
    }


    static void mainMenu() {
        while (true) {

            project.learn();

            int ch = sc.nextInt();

            if (ch == 1) {
                hand.subjectMenu(); // Open LMS
            }

            else if (ch == 2) {
                menu(); // Direct Quiz
            }

            else if (ch == 3) {
                currentUser = null;
                break;
            }

            else {
                System.out.println("Invalid Choice!");
            }
        }
    }

    public static void mainexec() {
        while (true) {
            // System.out.println("\n1.Signup 2.Login 3.Exit");
            project.banner1();
            int ch = sc.nextInt();

            if (ch == 1)
                signup();
            else if (ch == 2 && login())
                mainMenu();
            else if (ch == 3)
                break;
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        mainexec();
    }
}