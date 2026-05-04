package p1;

import java.util.*;
import java.io.*;

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
    
    // Loader animation
    public static void showLoader(String message, int duration) throws InterruptedException {
        String[] frames = {"|", "/", "-", "\\"};
        long startTime = System.currentTimeMillis();
        int frameIndex = 0;
        
        System.out.print(message);
        while (System.currentTimeMillis() - startTime < duration) {
            System.out.print("\r" + message + " " + frames[frameIndex % frames.length]);
            frameIndex++;
            Thread.sleep(100);
        }
        System.out.print("\r" + message + " Done!     \n");
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
    
    // Safe integer input with validation
    public static int getValidIntInput(Scanner sc, String prompt, int min, int max) throws InterruptedException {
        int input = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            String userInput = sc.next();
            
            try {
                input = Integer.parseInt(userInput);
                if (input >= min && input <= max) {
                    valid = true;
                } else {
                    printInBox("[!] Please enter a number between " + min + " and " + max + "!", RED);
                    Thread.sleep(1000);
                }
            } catch (NumberFormatException e) {
                printInBox("[!] Invalid input! Please enter a valid number!", RED);
                Thread.sleep(1000);
            }
        }
        return input;
    }
    
    // Safe string input
    public static String getValidStringInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }
    
    // Password validation - must be exactly 6 digits
    public static String getValidPassword(Scanner sc, String prompt) throws InterruptedException {
        String password;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            password = sc.next();
            
            if (password.length() == 6) {
                valid = true;
                return password;
            } else {
                printInBox("[!] Password must be exactly 6 digits (0-9 only)!", RED);
                Thread.sleep(1000);
            }
        }
        return "";
    }
}

class SubjectResult {
    String subject;
    int score;
    int timeTaken;
    boolean attempted;
     int totalQuestions;

    SubjectResult(String subject) {
        this.subject = subject;
        this.score = 0;
        this.timeTaken = 0;
        this.attempted = false;
         this.totalQuestions = 0; 
    }
}
class User {
    String username;
    String password;
    ArrayList<SubjectResult> results;

    User(String u, String p) {
        username = u;
        password = p;
        results = new ArrayList<>();
        
        // Initialize results for 3 subjects
        results.add(new SubjectResult("Java"));
        results.add(new SubjectResult("Python"));
        results.add(new SubjectResult("Aptitude"));
    }
    
    // Helper method to get result by subject name
    SubjectResult getResult(String subject) {
        for (SubjectResult sr : results) {
            if (sr.subject.equals(subject)) {
                return sr;
            }
        }
        return null;
    }
}

class QuizResult {
    String username;
    String subject;
    int score;
    int totalQuestions;
    int timeTaken; // in seconds
    String date;
    
    QuizResult(String u, String s, int sc, int total, int time) {
        username = u;
        subject = s;
        score = sc;
        totalQuestions = total;
        timeTaken = time;
        date = new Date().toString();
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
    static ArrayList<QuizResult> allResults = new ArrayList<>();
    static User currentUser = null;

    // Check if user already exists
    static boolean isUserExists(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Load questions from file
    static ArrayList<Question> loadQuestionsFromFile(String filename) {
        ArrayList<Question> questions = new ArrayList<>();
        
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String question = fileScanner.nextLine();
                if (question.isEmpty()) continue;
                
                String options = fileScanner.nextLine();
                String correct = fileScanner.nextLine();
                
                questions.add(new Question(question, options, correct));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            ConsoleUtils.printInBox("[!] Question file not found! Using default questions.", ConsoleUtils.YELLOW);
            // Default questions if file not found
            questions.add(new Question("What is Java?", "A. Language  B. OS  C. Browser  D. Hardware", "A"));
            questions.add(new Question("What is the size of int in Java?", "A. 2 bytes  B. 4 bytes  C. 8 bytes  D. 16 bytes", "B"));
            questions.add(new Question("What does OOP stand for?", "A. Object Oriented Programming  B. Other Programming", "A"));
        }
        
        return questions;
    }

    // Get subject name based on choice
    static String getSubjectName(int ch) {
        if (ch == 1) return "Java";
        else if (ch == 2) return "Python";
        else return "Aptitude";
    }

    // ---------------- SIGNUP ----------------
    static void signup() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("SIGN UP");
        
        ConsoleUtils.printCenteredWithBorder(ConsoleUtils.GREEN + "Create New Account" + ConsoleUtils.RESET);
        
        String u = ConsoleUtils.getValidStringInput(sc, ConsoleUtils.CYAN + "+--------------------------------------------------+\n" +
                         "| Enter Username: " + ConsoleUtils.RESET);
        
        // Check if user already exists
        if (isUserExists(u)) {
            ConsoleUtils.printInBox("[X] User already exists! Please try a different username.", ConsoleUtils.RED);
            ConsoleUtils.pressAnyKey(sc);
            return;
        }
        
        String p = ConsoleUtils.getValidPassword(sc, ConsoleUtils.CYAN + "| Enter Password (6 digits): " + ConsoleUtils.RESET);
        
        // Show loader
        ConsoleUtils.showLoader("Creating account", 1500);
        
        users.add(new User(u, p));
        
        ConsoleUtils.printInBox("[+] Signup Successful!", ConsoleUtils.GREEN);
        ConsoleUtils.pressAnyKey(sc);
    }

    // ---------------- LOGIN ----------------
    static boolean login() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("LOGIN");
        
        ConsoleUtils.printCenteredWithBorder(ConsoleUtils.YELLOW + "Welcome Back!" + ConsoleUtils.RESET);
        
        String u = ConsoleUtils.getValidStringInput(sc, ConsoleUtils.CYAN + "+--------------------------------------------------+\n" +
                         "| Username: " + ConsoleUtils.RESET);
        
        String p = ConsoleUtils.getValidStringInput(sc, ConsoleUtils.CYAN + "| Password: " + ConsoleUtils.RESET);

        ConsoleUtils.showLoader("Verifying credentials", 1000);
        
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
        
        // Show loader first
        ConsoleUtils.showLoader("Generating OTP", 1500);
        
        int otp = 1000 + (int) (Math.random() * 9000);
        
        ConsoleUtils.printInBox("Your OTP: " + otp, ConsoleUtils.YELLOW);
        
        int uotp = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.CYAN + "Enter OTP: " + ConsoleUtils.RESET, 1000, 9999);

        if (otp == uotp) {
            ConsoleUtils.printInBox("[+] OTP Verified!", ConsoleUtils.GREEN);
            return true;
        } else {
            ConsoleUtils.printInBox("[X] Wrong OTP!", ConsoleUtils.RED);
            return false;
        }
    }

    // ---------------- PROFILE ----------------
static void showProfile() throws InterruptedException {
    ConsoleUtils.clearAndScroll();
    ConsoleUtils.printHeader("USER PROFILE");
    
    String profileBox = 
        "+--------------------------------------------------+\n" +
        "|              PROFILE DETAILS                     |\n" +
        "+--------------------------------------------------+\n" +
        String.format("|Username    : %-36s|\n", currentUser.username) +
        "|                                                  |\n" +
        "+--------------------------------------------------+\n";
    
    ConsoleUtils.printInBox(profileBox, ConsoleUtils.CYAN);
    System.out.println(ConsoleUtils.YELLOW+" SUBJECT PERFORMANCE    ");
    System.out.println(ConsoleUtils.YELLOW + "\n+----------------+----------+----------------+" + ConsoleUtils.RESET);
    System.out.printf(ConsoleUtils.YELLOW + "| %-12s | %-6s | %-13s |\n" + ConsoleUtils.RESET, "Subject", "Score", "Time Taken");
    System.out.println(ConsoleUtils.YELLOW + "+----------------+----------+----------------+" + ConsoleUtils.RESET);
    
    for (SubjectResult sr : currentUser.results) {
        if (sr.attempted) {
            int minutes = sr.timeTaken / 60;
            int seconds = sr.timeTaken % 60;
            String timeStr = String.format("%d min %d sec", minutes, seconds);
            System.out.printf("| %-12s |    %-3d   | %-13s |\n", sr.subject, sr.score, timeStr);
        } else {
            System.out.printf("| %-12s |  %-6s | %-13s |\n", sr.subject, "Not Taken", "-");
        }
    }
    System.out.println(ConsoleUtils.YELLOW + "+----------------+----------+----------------+" + ConsoleUtils.RESET);
    
    // Calculate total performance
    int totalScore = 0;
    int totalAttempts = 0;
    int totalTime = 0;
    
    for (SubjectResult sr : currentUser.results) {
        if (sr.attempted) {
            totalScore += sr.score;
            totalAttempts++;
            totalTime += sr.timeTaken;
        }
    }
    
    if (totalAttempts > 0) {
        int avgScore = totalScore / totalAttempts;
        int avgTime = totalTime / totalAttempts;
        int minutes = avgTime / 60;
        int seconds = avgTime % 60;
        
        System.out.println(ConsoleUtils.GREEN + "\n+----------------+----------+----------------+" + ConsoleUtils.RESET);
        System.out.printf(ConsoleUtils.GREEN + "| %-12s |    %-3d   | %-13s |\n" + ConsoleUtils.RESET, "AVERAGE", avgScore, String.format("%d min %d sec", minutes, seconds));
        System.out.println(ConsoleUtils.GREEN + "+----------------+----------+----------------+" + ConsoleUtils.RESET);
    }
    
    ConsoleUtils.pressAnyKey(sc);
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
        
        ConsoleUtils.printHeader("SUBJECT SELECTION");
        
        project.intro();
        int ch = ConsoleUtils.getValidIntInput(sc, "", 1, 4);
        
        // Handle exit option
        if (ch == 4) {
            ConsoleUtils.printInBox("[+] Returning to main menu...", ConsoleUtils.YELLOW);
            Thread.sleep(1000);
            return;
        }
        
        String subject = getSubjectName(ch);
        
        // Check if already attempted
      SubjectResult userResult = currentUser.getResult(subject);
if (userResult != null && userResult.attempted) {
            ConsoleUtils.printInBox("[!] You have already attempted the " + subject + " quiz!", ConsoleUtils.YELLOW);
            ConsoleUtils.pressAnyKey(sc);
            return;
        }
        
        if (!otp()) {
            return;
        }
        
        ConsoleUtils.showLoader("Loading questions", 1500);
        
        ArrayList<Question> questions = new ArrayList<>();
        
        // Load questions from text files based on subject choice
        if (ch == 1) {
            questions = loadQuestionsFromFile("java_questions.txt");
        } else if (ch == 2) {
            questions = loadQuestionsFromFile("python_questions.txt");
        } else if (ch == 3) {
            questions = loadQuestionsFromFile("aptitude_questions.txt");
        }
        
        if (questions.isEmpty()) {
            ConsoleUtils.printInBox("[!] No questions found for this subject!", ConsoleUtils.RED);
            ConsoleUtils.pressAnyKey(sc);
            return;
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
            String ans = ConsoleUtils.getValidStringInput(sc, ConsoleUtils.GREEN + "[?] Your Answer (0 to skip): " + ConsoleUtils.RESET);
            long end = System.currentTimeMillis();
            int spent = (int)((end - start) / 1000);
            a.timeSpent += spent;
            
            if (!ans.equals("0")) {
                a.answer = ans.toUpperCase();
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
            
            int choice = ConsoleUtils.getValidIntInput(sc, "", 1, 6);
            
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
                    int jump = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.CYAN + "Jump to question number (1-" + n + "): " + ConsoleUtils.RESET, 1, n);
                    current = jump - 1;
                    ConsoleUtils.printInBox("[+] Jumped to Question " + jump, ConsoleUtils.GREEN);
                    Thread.sleep(800);
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
                        ConsoleUtils.showLoader("Submitting quiz", 1000);
                        quizCompleted = true;
                    }
                    break;
                    
                default:
                    ConsoleUtils.printInBox("[X] Invalid choice! Please select 1-6", ConsoleUtils.RED);
                    Thread.sleep(800);
            }
        }
        
        int totalQuizTime = (int)((System.currentTimeMillis() - examStart) / 1000);
        int score = calculateScore(questions, attempts);
        
        // Store results for the subject
        SubjectResult result = currentUser.getResult(subject);
if (result != null) {
    result.score = score;
    result.timeTaken = totalQuizTime;
    result.attempted = true;
     result.totalQuestions = n;
}
        
        // Store in global results list for leaderboard
        allResults.add(new QuizResult(currentUser.username, subject, score, n, totalQuizTime));
        
        ConsoleUtils.printInBox("[+] " + subject + " Quiz Completed! Score: " + score + "/" + n, ConsoleUtils.GREEN);
        ConsoleUtils.printInBox("[+] Time Taken: " + (totalQuizTime/60) + " minutes " + (totalQuizTime%60) + " seconds", ConsoleUtils.CYAN);
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
    
    // ---------------- SUBJECT WISE LEADERBOARD ----------------
    static void leaderboard() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("SUBJECT SELECTION FOR LEADERBOARD");
        
        System.out.println(ConsoleUtils.CYAN + "+--------------------------------------------------+" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  1. Java Leaderboard                             |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  2. Python Leaderboard                           |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  3. Aptitude Leaderboard                         |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  4. Back to Main Menu                            |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.CYAN + "+--------------------------------------------------+" + ConsoleUtils.RESET);
        
        int ch = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET, 1, 4);
        
        if (ch == 4) return;
        
        String subject = getSubjectName(ch);
        ConsoleUtils.showLoader("Loading " + subject + " leaderboard", 1000);
        
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader(subject.toUpperCase() + " LEADERBOARD");
        
        // Filter results for selected subject
        ArrayList<QuizResult> subjectResults = new ArrayList<>();
        for (QuizResult result : allResults) {
            if (result.subject.equals(subject)) {
                subjectResults.add(result);
            }
        }
        
        if (subjectResults.isEmpty()) {
            ConsoleUtils.printInBox("[!] No attempts yet for " + subject + " quiz!", ConsoleUtils.YELLOW);
            ConsoleUtils.pressAnyKey(sc);
            return;
        }
        
        // Sort by score (descending) and then by time (ascending)
        subjectResults.sort((a, b) -> {
            if (a.score != b.score) {
                return Integer.compare(b.score, a.score);
            } else {
                return Integer.compare(a.timeTaken, b.timeTaken);
            }
        });
        
        System.out.println(ConsoleUtils.CYAN +
            "+------------------------------------------------------------+\n" +
            "|  Rank  |  Username          |  Score  |     Time Taken     |\n" +
            "+------------------------------------------------------------+" + ConsoleUtils.RESET);
        
        int rank = 1;
        for (QuizResult result : subjectResults) {
            if (rank <= 10) {
                int minutes = result.timeTaken / 60;
                int seconds = result.timeTaken % 60;
                String timeStr = String.format("%02d:%02d", minutes, seconds);
                
                System.out.printf(ConsoleUtils.YELLOW + "|  %-4d |  %-16s |   %-3d   |      %-8s      |\n" + ConsoleUtils.RESET, 
                                rank, result.username, result.score, timeStr);
            }
            rank++;
        }
        
        System.out.println(ConsoleUtils.CYAN + "+------------------------------------------------------------+" + ConsoleUtils.RESET);
        
        // Show current user's rank
        int userRank = 1;
        for (QuizResult result : subjectResults) {
            if (result.username.equals(currentUser.username)) {
                ConsoleUtils.printInBox("[+] Your Rank: " + userRank + " | Score: " + result.score + "/" + result.totalQuestions, ConsoleUtils.GREEN);
                break;
            }
            userRank++;
        }
        
        ConsoleUtils.pressAnyKey(sc);
    }
    
    // ---------------- RESULT ----------------
    static void showResult() throws InterruptedException {
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader("SUBJECT SELECTION FOR RESULT");
        
        System.out.println(ConsoleUtils.CYAN + "+--------------------------------------------------+" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  1. Java Result                                |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  2. Python Result                              |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  3. Aptitude Result                            |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.YELLOW + "|  4. Back to Main Menu                          |" + ConsoleUtils.RESET);
        System.out.println(ConsoleUtils.CYAN + "+--------------------------------------------------+" + ConsoleUtils.RESET);
        
        int ch = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET, 1, 4);
        
        if (ch == 4) return;
        
        String subject = getSubjectName(ch);
        
    SubjectResult existingResult = currentUser.getResult(subject);
if (existingResult == null || !existingResult.attempted) {
            ConsoleUtils.printInBox("[!] You haven't attempted the " + subject + " quiz yet!", ConsoleUtils.RED);
            ConsoleUtils.pressAnyKey(sc);
            return;
        }
        
        ConsoleUtils.clearAndScroll();
        ConsoleUtils.printHeader(subject.toUpperCase() + " QUIZ RESULT");
        
        SubjectResult result = currentUser.getResult(subject);
int score = result.score;
int timeTaken = result.timeTaken;
int total = 0; // Need to get actual total questions

// Get actual total questions based on subject
if (subject.equals("Java")) total = loadQuestionsFromFile("java_questions.txt").size();
else if (subject.equals("Python")) total = loadQuestionsFromFile("python_questions.txt").size();
else if (subject.equals("Aptitude")) total = loadQuestionsFromFile("aptitude_questions.txt").size();
if (total == 0) total = 3; // fallback
        int wrong = total - score;
        double percent = (score * 100.0) / total;
        int minutes = timeTaken / 60;
        int seconds = timeTaken % 60;
        
        String resultBox = 
            "+--------------------------------------------------+\n" +
            "|              " + subject.toUpperCase() + " QUIZ RESULT                   |\n" +
            "+--------------------------------------------------+\n" +
            String.format("|  Score       : %d / %d %28s\n", score, total, "|") +
            String.format("|  Correct     : %d %34s\n", score, "|") +
            String.format("|  Wrong       : %d %34s\n", wrong, "|") +
            String.format("|  Percentage  : %.2f%% %30s\n", percent, "|") +
            String.format("|  Time Taken  : %d min %d sec %21s\n", minutes, seconds, "|") +
            "+--------------------------------------------------+";
        
        ConsoleUtils.printInBox(resultBox, ConsoleUtils.CYAN);
        
        if (percent >= 40) {
            ConsoleUtils.printInBox("[PASS] - Congratulations " + currentUser.username + "!", ConsoleUtils.GREEN);
        } else {
            ConsoleUtils.printInBox("[FAIL] - Better Luck Next Time!", ConsoleUtils.RED);
        }
        
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
                "|      1. [*] Take Quiz                            |\n" +
                "|      2. [*] View Result                          |\n" +
                "|      3. [*] Leaderboard                          |\n" +
                "|      4. [*] My Profile                           |\n" +
                "|      5. [*] Learning Resources                   |\n" +
                "|      6. [*] Logout                               |\n" +
                "|                                                  |\n" +
                "+--------------------------------------------------+";
            
            ConsoleUtils.printInBox(menuBox, ConsoleUtils.CYAN);
            int ch = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET, 1, 6);
            
            if (ch == 1) startQuiz();
            else if (ch == 2) showResult();
            else if (ch == 3) leaderboard();
            else if (ch == 4) showProfile();
            else if (ch == 5) hand.subjectMenu();
            else return;
        }
    }
    
    static void mainMenu() throws InterruptedException {
        while (true) {
            ConsoleUtils.clearAndScroll();
            ConsoleUtils.printHeader("LEARNING MANAGEMENT SYSTEM");
            project.learn();
            
            int ch = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET, 1, 3);
            
            if (ch == 1) {
                hand.subjectMenu();
            } else if (ch == 2) {
                menu();
            } else if (ch == 3) {
                currentUser = null;
                break;
            }
        }
    }
    
    public static void mainexec() throws InterruptedException {
        while (true) {
            ConsoleUtils.clearAndScroll();
            ConsoleUtils.printHeader("WELCOME TO QUIZ SYSTEM");
            project.banner1();
            
            int ch = ConsoleUtils.getValidIntInput(sc, ConsoleUtils.GREEN + "Enter your choice: " + ConsoleUtils.RESET, 1, 3);
            
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