package p1;

import java.util.*;

// ANSI Color and Console Utility Class
class ConsoleUtils {
    // ANSI Colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    // Background Colors
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    
    // Text Styles
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    
    // Clear screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    // Get console width (default 120 if can't detect)
    public static int getConsoleWidth() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                Process process = Runtime.getRuntime().exec("cmd /c mode con");
                try (java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("Columns")) {
                            String[] parts = line.trim().split(":");
                            if (parts.length > 1) {
                                return Integer.parseInt(parts[1].trim());
                            }
                        }
                    }
                }
            } else {
                Process process = Runtime.getRuntime().exec("tput cols");
                try (java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()))) {
                    String line = reader.readLine();
                    if (line != null) {
                        return Integer.parseInt(line);
                    }
                }
            }
        } catch (Exception e) {
            return 120;
        }
        return 120;
    }
    
    // Center text with border
    public static void printCenteredWithBorder(String text) {
        int width = getConsoleWidth() - 4;
        String[] lines = text.split("\n");
        
        System.out.println(CYAN + "+" + "-".repeat(width) + "+" + RESET);
        
        for (String line : lines) {
            String plainLine = line.replaceAll("\u001B\\[[;\\d]*m", "");
            int padding = (width - plainLine.length()) / 2;
            
            System.out.print(CYAN + "|" + RESET);
            if (padding > 0) System.out.print(" ".repeat(padding));
            System.out.print(line);
            if (padding > 0) System.out.print(" ".repeat(width - plainLine.length() - padding));
            System.out.println(CYAN + "|" + RESET);
        }
        
        System.out.println(CYAN + "+" + "-".repeat(width) + "+" + RESET);
    }
    
    // Print centered text
    public static void printCentered(String text) {
        int width = getConsoleWidth();
        String[] lines = text.split("\n");
        
        for (String line : lines) {
            String plainLine = line.replaceAll("\u001B\\[[;\\d]*m", "");
            int padding = (width - plainLine.length()) / 2;
            if (padding > 0) System.out.print(" ".repeat(padding));
            System.out.println(line);
        }
    }
    
    // Print in a bordered box
    public static void printInBox(String text, String borderColor) {
        int width = getConsoleWidth() - 4;
        String[] lines = text.split("\n");
        int maxLen = 0;
        
        for (String line : lines) {
            String plainLine = line.replaceAll("\u001B\\[[;\\d]*m", "");
            maxLen = Math.max(maxLen, plainLine.length());
        }
        
        int boxWidth = Math.min(maxLen + 4, width);
        
        System.out.println(borderColor + "+" + "-".repeat(boxWidth - 2) + "+" + RESET);
        
        for (String line : lines) {
            String plainLine = line.replaceAll("\u001B\\[[;\\d]*m", "");
            int padding = (boxWidth - 2 - plainLine.length()) / 2;
            
            System.out.print(borderColor + "|" + RESET);
            if (padding > 0) System.out.print(" ".repeat(padding));
            System.out.print(line);
            if (padding > 0) System.out.print(" ".repeat(boxWidth - 2 - plainLine.length() - padding));
            System.out.println(borderColor + "|" + RESET);
        }
        
        System.out.println(borderColor + "+" + "-".repeat(boxWidth - 2) + "+" + RESET);
    }
    
    // Print header with separator
    public static void printHeader(String title) {
        int width = getConsoleWidth();
        String coloredTitle = YELLOW + BOLD + title + RESET;
        int padding = (width - title.length()) / 2;
        
        System.out.println();
        System.out.println(CYAN + "=".repeat(width) + RESET);
        if (padding > 0) System.out.print(" ".repeat(padding));
        System.out.println(coloredTitle);
        System.out.println(CYAN + "=".repeat(width) + RESET);
    }
    
    // Animated scroll effect
    public static void scrollUp(int lines) throws InterruptedException {
        for (int i = 0; i < lines; i++) {
            System.out.println();
            Thread.sleep(30);
        }
    }
    
    // Animated text reveal
    public static void typewriterEffect(String text, int delay) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delay);
        }
        System.out.println();
    }
    
    // Press any key to continue
    public static void pressAnyKey(Scanner sc) {
        System.out.print(GREEN + "\n[ Press Enter to continue ]" + RESET);
        try {
            sc.nextLine();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
        }
    }
    
    // Clear and scroll
    public static void clearAndScroll() throws InterruptedException {
        scrollUp(2);
        clearScreen();
        scrollUp(1);
    }
}

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
    static void signup() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("SIGN UP");
        
        ConsoleUtils.printCenteredWithBorder(ConsoleUtils.GREEN + "Create New Account" + ConsoleUtils.RESET);
        
        System.out.print(ConsoleUtils.CYAN + "+--------------------------------------------------+\n" +
                         "| Enter Username: " + ConsoleUtils.RESET);
        String u = sc.next();
        
        System.out.print(ConsoleUtils.CYAN + "| Enter Password: " + ConsoleUtils.RESET);
        String p = sc.next();
        
        users.add(new User(u, p));
        
        ConsoleUtils.printInBox("[+] Signup Successful!", ConsoleUtils.GREEN);
        ConsoleUtils.pressAnyKey(sc);
    }

    // ---------------- LOGIN ----------------
    static boolean login() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("LOGIN");
        
        ConsoleUtils.printCenteredWithBorder(ConsoleUtils.YELLOW + "Welcome Back!" + ConsoleUtils.RESET);
        
        System.out.print(ConsoleUtils.CYAN + "+--------------------------------------------------+\n" +
                         "| Username: " + ConsoleUtils.RESET);
        String u = sc.next();
        
        System.out.print(ConsoleUtils.CYAN + "| Password: " + ConsoleUtils.RESET);
        String p = sc.next();

        for (User user : users) {
            if (user.username.equals(u) && user.password.equals(p)) {
                currentUser = user;
                ConsoleUtils.printInBox("[+] Login Successful!", ConsoleUtils.GREEN);
                ConsoleUtils.typewriterEffect("Welcome " + u + "!", 50);
                Thread.sleep(1000);
                return true;
            }
        }

        ConsoleUtils.printInBox("[X] Invalid Credentials!", ConsoleUtils.RED);
        ConsoleUtils.pressAnyKey(sc);
        return false;
    }

    // ---------------- OTP ----------------
    static boolean otp() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("OTP VERIFICATION");
        
        int otp = 1000 + (int) (Math.random() * 9000);
        
        ConsoleUtils.printInBox("Your OTP: " + otp, ConsoleUtils.YELLOW);
        
        System.out.print(ConsoleUtils.CYAN + "Enter OTP: " + ConsoleUtils.RESET);
        int uotp = sc.nextInt();

        if (otp == uotp) {
            ConsoleUtils.printInBox("[+] OTP Verified!", ConsoleUtils.GREEN);
            return true;
        } else {
            ConsoleUtils.printInBox("[X] Wrong OTP!", ConsoleUtils.RED);
            return false;
        }
    }

    // ---------------- BEAUTIFUL QUESTION PALETTE ----------------
    static void showPalette(ArrayList<Attempt> attempts) throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("QUESTION PALETTE");
        
        int n = attempts.size();
        
        System.out.println(ConsoleUtils.CYAN + "+" + "=".repeat(70) + "+" + ConsoleUtils.RESET);
        System.out.printf(ConsoleUtils.YELLOW + "| %-3s | %-10s | %-15s | %-30s |\n" + ConsoleUtils.RESET, 
                         "Q.No", "Status", "Marked", "Answer");
        System.out.println(ConsoleUtils.CYAN + "+" + "-".repeat(70) + "+" + ConsoleUtils.RESET);
        
        for (int i = 0; i < n; i++) {
            Attempt a = attempts.get(i);
            String status, marked, answer;
            
            if (!a.visited) {
                status = ConsoleUtils.RED + "Not Visited" + ConsoleUtils.RESET;
                marked = ConsoleUtils.RED + "No" + ConsoleUtils.RESET;
                answer = ConsoleUtils.RED + "-" + ConsoleUtils.RESET;
            } else if (a.answer.equals("")) {
                status = ConsoleUtils.YELLOW + "Visited" + ConsoleUtils.RESET;
                marked = a.marked ? ConsoleUtils.GREEN + "Yes" + ConsoleUtils.RESET : ConsoleUtils.RED + "No" + ConsoleUtils.RESET;
                answer = ConsoleUtils.YELLOW + "Not Answered" + ConsoleUtils.RESET;
            } else {
                status = ConsoleUtils.GREEN + "Answered" + ConsoleUtils.RESET;
                marked = a.marked ? ConsoleUtils.GREEN + "Yes" + ConsoleUtils.RESET : ConsoleUtils.RED + "No" + ConsoleUtils.RESET;
                answer = ConsoleUtils.GREEN + a.answer + ConsoleUtils.RESET;
            }
            
            System.out.printf("| %-3d | %-10s | %-15s | %-30s |\n", 
                             (i+1), status, marked, answer);
        }
        
        System.out.println(ConsoleUtils.CYAN + "+" + "=".repeat(70) + "+" + ConsoleUtils.RESET);
        
        // Legend
        System.out.println("\n" + ConsoleUtils.YELLOW + "LEGEND:" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.GREEN + "[Answered] " + ConsoleUtils.RESET + "- Question answered");
        System.out.println(ConsoleUtils.YELLOW + "[Visited] " + ConsoleUtils.RESET + "- Question seen but not answered");
        System.out.println(ConsoleUtils.RED + "[Not Visited] " + ConsoleUtils.RESET + "- Question not yet seen");
        System.out.println(ConsoleUtils.GREEN + "[Marked] " + ConsoleUtils.RESET + "- Question marked for review");
        
        ConsoleUtils.pressAnyKey(sc);
    }
    
    // ---------------- QUIZ ----------------
    static void startQuiz() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        
        if (currentUser.attempted) {
            ConsoleUtils.printInBox("[!] You have already attempted the quiz!", ConsoleUtils.YELLOW);
            ConsoleUtils.pressAnyKey(sc);
            return;
        }
        
        if (!otp()) {
            return;
        }
        
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("SUBJECT SELECTION");
        
        project.intro();
        int ch = sc.nextInt();
        
        ArrayList<Question> questions = new ArrayList<>();
        
        if (ch == 1) {
            questions.add(new Question("What is Java?", "A. Language  B. OS  C. Browser  D. Hardware", "A"));
            questions.add(new Question("What is the size of int in Java?", "A. 2 bytes  B. 4 bytes  C. 8 bytes  D. 16 bytes", "B"));
            questions.add(new Question("What does OOP stand for?", "A. Object Oriented Programming  B. Other Programming", "A"));
        } else if (ch == 2) {
            questions.add(new Question("Who developed C language?", "A. Dennis Ritchie  B. James Gosling", "A"));
            questions.add(new Question("C is which level language?", "A. Low Level  B. Middle Level  C. High Level", "B"));
            questions.add(new Question("What is the extension of C file?", "A. .java  B. .c  C. .py", "B"));
        } else if (ch == 3) {
            questions.add(new Question("2 + 2 = ?", "", "4"));
            questions.add(new Question("5 x 3 = ?", "", "15"));
            questions.add(new Question("10 / 2 = ?", "", "5"));
        }
        
        Collections.shuffle(questions);
        int n = questions.size();
        ArrayList<Attempt> attempts = new ArrayList<>();
        for (int i = 0; i < n; i++) attempts.add(new Attempt());
        
        int current = 0;
        int totalTime = n * 30;
        long examStart = System.currentTimeMillis();
        boolean quizCompleted = false;
        
        while (!quizCompleted) {
            ConsoleUtils.clearAndScroll();
            
            int elapsed = (int)((System.currentTimeMillis() - examStart) / 1000);
            int remainingTotal = totalTime - elapsed;
            
            if (remainingTotal <= 0) {
                ConsoleUtils.printInBox("[!] TIME OVER! Auto-submitting...", ConsoleUtils.RED);
                Thread.sleep(1500);
                break;
            }
            
            Question q = questions.get(current);
            Attempt a = attempts.get(current);
            
            int perLimit = 30;
            int remainingQ = perLimit - a.timeSpent;
            
            if (remainingQ <= 0) {
                ConsoleUtils.printInBox("[!] Time over for this question!", ConsoleUtils.RED);
                if (current < n - 1) {
                    current++;
                } else {
                    ConsoleUtils.printInBox("[!] Last question - Please submit or jump to other questions!", ConsoleUtils.YELLOW);
                    Thread.sleep(1500);
                }
                continue;
            }
            
            a.visited = true;
            
            // Show if it's the last question
            if (current == n - 1) {
                ConsoleUtils.printHeader("LAST QUESTION - " + (current + 1) + "/" + n);
                ConsoleUtils.printInBox("[!] THIS IS THE LAST QUESTION! You can submit after answering.", ConsoleUtils.YELLOW);
            } else {
                ConsoleUtils.printHeader("QUESTION " + (current + 1) + "/" + n);
            }
            
            // Center the question
            String centeredQuestion = q.question;
            int width = ConsoleUtils.getConsoleWidth();
            int qPadding = (width - q.question.length()) / 2;
            if (qPadding > 0) centeredQuestion = " ".repeat(qPadding) + q.question;
            System.out.println(ConsoleUtils.CYAN + centeredQuestion + ConsoleUtils.RESET);
            
            // Center the options
            if (!q.options.equals("")) {
                String centeredOptions = q.options;
                int oPadding = (width - q.options.length()) / 2;
                if (oPadding > 0) centeredOptions = " ".repeat(oPadding) + q.options;
                System.out.println(ConsoleUtils.GREEN + centeredOptions + ConsoleUtils.RESET);
            }
            
            System.out.println(ConsoleUtils.YELLOW + "[>] Question Time Left: " + remainingQ + " sec" + ConsoleUtils.RESET);
            System.out.println(ConsoleUtils.RED + "[>] Total Time Left: " + remainingTotal + " sec" + ConsoleUtils.RESET);
            
            if (remainingTotal <= 10) {
                ConsoleUtils.printInBox("[!] LAST " + remainingTotal + " SECONDS!", ConsoleUtils.RED);
            }
            
            long start = System.currentTimeMillis();
            System.out.print(ConsoleUtils.GREEN + "[?] Your Answer (0 to skip): " + ConsoleUtils.RESET);
            String ans = sc.next();
            long end = System.currentTimeMillis();
            int spent = (int)((end - start) / 1000);
            a.timeSpent += spent;
            
            if (!ans.equals("0")) {
                a.answer = ans;
                if (current == n - 1) {
                    ConsoleUtils.printInBox("[+] Answer recorded for last question!", ConsoleUtils.GREEN);
                    Thread.sleep(800);
                }
            }
            
            // Center the navigation menu
            int widthNav = ConsoleUtils.getConsoleWidth();
            String navMenu = 
                "+---------------------------------------------------+\n" +
                "|  1. Next    2. Previous    3. Jump               |\n" +
                "|  4. Mark    5. Palette     6. Submit             |\n" +
                "+---------------------------------------------------+";
            
            String[] navLines = navMenu.split("\n");
            for (String line : navLines) {
                int padding = (widthNav - line.length()) / 2;
                if (padding > 0) System.out.print(" ".repeat(padding));
                System.out.println(ConsoleUtils.YELLOW + line + ConsoleUtils.RESET);
            }
            
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1: // Next
                    if (current < n - 1) {
                        current++;
                    } else {
                        ConsoleUtils.printInBox("[!] This is the last question! Use Submit (6) to finish or Jump (3) to go to other questions.", ConsoleUtils.YELLOW);
                        Thread.sleep(1500);
                    }
                    break;
                    
                case 2: // Previous
                    if (current > 0) {
                        current--;
                    } else {
                        ConsoleUtils.printInBox("[!] This is the first question!", ConsoleUtils.YELLOW);
                        Thread.sleep(800);
                    }
                    break;
                    
                case 3: // Jump
                    System.out.print(ConsoleUtils.CYAN + "Jump to question number (1-" + n + "): " + ConsoleUtils.RESET);
                    int jump = sc.nextInt();
                    if (jump >= 1 && jump <= n) {
                        current = jump - 1;
                        ConsoleUtils.printInBox("[+] Jumped to Question " + jump, ConsoleUtils.GREEN);
                        Thread.sleep(800);
                    } else {
                        ConsoleUtils.printInBox("[X] Invalid question number!", ConsoleUtils.RED);
                        Thread.sleep(800);
                    }
                    break;
                    
                case 4: // Mark
                    a.marked = true;
                    ConsoleUtils.printInBox("[+] Question " + (current + 1) + " marked for review!", ConsoleUtils.GREEN);
                    Thread.sleep(800);
                    break;
                    
                case 5: // Palette
                    showPalette(attempts);
                    break;
                    
                case 6: // Submit
                    ConsoleUtils.printInBox("[!] Are you sure you want to submit?", ConsoleUtils.YELLOW);
                    System.out.print(ConsoleUtils.GREEN + "Submit? (y/n): " + ConsoleUtils.RESET);
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("y")) {
                        quizCompleted = true;
                    }
                    break;
                    
                default:
                    ConsoleUtils.printInBox("[X] Invalid choice! Please select 1-6", ConsoleUtils.RED);
                    Thread.sleep(800);
            }
        }
        
        currentUser.score = calculateScore(questions, attempts);
        currentUser.attempted = true;
        
        ConsoleUtils.printInBox("[+] Quiz Completed! Score: " + currentUser.score + "/" + n, ConsoleUtils.GREEN);
        ConsoleUtils.pressAnyKey(sc);
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
    static void showResult() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("QUIZ RESULT");
        
        int correct = currentUser.score;
        int total = 3;
        int wrong = total - correct;
        double percent = (correct * 100.0) / total;
        
        String resultBox = 
            "+--------------------------------------------------+\n" +
            "|              QUIZ RESULT SUMMARY                 |\n" +
            "+--------------------------------------------------+\n" +
            String.format("|  Score       : %d / %d %28s\n", correct, total, "|") +
            String.format("|  Correct     : %d %34s\n", correct, "|") +
            String.format("|  Wrong       : %d %34s\n", wrong, "|") +
            String.format("|  Percentage  : %.2f%% %30s\n", percent, "|") +
            "+--------------------------------------------------+";
        
        ConsoleUtils.printInBox(resultBox, ConsoleUtils.CYAN);
        
        if (percent >= 40) {
            ConsoleUtils.printInBox("[PASS] - Congratulations " + currentUser.username + "!", ConsoleUtils.GREEN);
        } else {
            ConsoleUtils.printInBox("[FAIL] - Better Luck Next Time!", ConsoleUtils.RED);
        }
        
        ConsoleUtils.pressAnyKey(sc);
    }
    
    static void evaluate(ArrayList<Question> questions, ArrayList<Attempt> attempts) throws InterruptedException {
        int correct = 0, wrong = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (attempts.get(i).answer.equalsIgnoreCase(questions.get(i).correct)) correct++;
            else if (!attempts.get(i).answer.equals("")) wrong++;
        }
        currentUser.score = correct;
        showResult();
    }
    
    static void leaderboard() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("LEADERBOARD");
        
        users.sort((a, b) -> Integer.compare(b.score, a.score));
        
        System.out.println(ConsoleUtils.CYAN +
            "+--------------------------------------------------+\n" +
            "|  Rank  |  Username          |     Score          |\n" +
            "+--------------------------------------------------+" + ConsoleUtils.RESET);
        
        int rank = 1;
        for (User u : users) {
            if (rank <= 10) {
                System.out.printf(ConsoleUtils.YELLOW + "|  %-4d |  %-16s |      %-8d     |\n" + ConsoleUtils.RESET, rank, u.username, u.score);
            }
            rank++;
        }
        
        System.out.println(ConsoleUtils.CYAN + "+--------------------------------------------------+" + ConsoleUtils.RESET);
        ConsoleUtils.pressAnyKey(sc);
    }
    
    // ---------------- MENU ----------------
    public static void menu() throws InterruptedException {
        while (true) {
            ConsoleUtils.clearAndScroll();
            ConsoleUtils.printHeader("MAIN MENU");
            
            String menuBox = 
                "+--------------------------------------------------+\n" +
                "|                                                  |\n" +
                "|      1. [*] Take Quiz                           |\n" +
                "|      2. [*] View Result                         |\n" +
                "|      3. [*] Leaderboard                         |\n" +
                "|      4. [*] Learning Resources                  |\n" +
                "|      5. [*] Logout                              |\n" +
                "|                                                  |\n" +
                "+--------------------------------------------------+";
            
            ConsoleUtils.printInBox(menuBox, ConsoleUtils.CYAN);
            System.out.print(ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET);
            int ch = sc.nextInt();
            
            if (ch == 1) startQuiz();
            else if (ch == 2) showResult();
            else if (ch == 3) leaderboard();
            else if (ch == 4) hand.subjectMenu();
            else return;
        }
    }
    
    static void mainMenu() throws InterruptedException {
        while (true) {
            ConsoleUtils.clearAndScroll();
            ConsoleUtils.printHeader("LEARNING MANAGEMENT SYSTEM");
            project.learn();
            
            System.out.print(ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET);
            int ch = sc.nextInt();
            
            if (ch == 1) {
                hand.subjectMenu();
            } else if (ch == 2) {
                menu();
            } else if (ch == 3) {
                currentUser = null;
                break;
            } else {
                ConsoleUtils.printInBox("[X] Invalid Choice!", ConsoleUtils.RED);
                Thread.sleep(1000);
            }
        }
    }
    
    public static void mainexec() throws InterruptedException {
        while (true) {
            ConsoleUtils.clearAndScroll();
            ConsoleUtils.printHeader("WELCOME TO QUIZ SYSTEM");
            project.banner1();
            
            System.out.print(ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET);
            int ch = sc.nextInt();
            
            if (ch == 1) signup();
            else if (ch == 2 && login()) mainMenu();
            else if (ch == 3) {
                ConsoleUtils.printInBox("[+] Thank you for using Quiz System!", ConsoleUtils.GREEN);
                System.exit(0);
            }
        }
    }
    
    // ---------------- MAIN ----------------
    public static void main(String[] args) throws InterruptedException {
        mainexec();
    }
}