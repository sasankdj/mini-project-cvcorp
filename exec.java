package p1;

import java.util.Scanner;

public class exec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        project.QuizLoomAscii();
        
        // Loading animation with progress bar
        showProgressBar("Starting Quiz Loom", 2500);
        
        // Spinner loading animation (ASCII only)
        showSpinnerAnimation("Loading Quiz Modules", 1800);
        
        // Dots animation
        showDotsAnimation("Preparing Questions", 1200);
        
        try {
            QuizSystem.mainexec();
        } catch (InterruptedException e) {
            // Ignore or log
            e.printStackTrace();
        }
        System.out.println("Press enter to continue..");
        sc.nextLine();
    }
    
    // Method to get console width
    private static int getConsoleWidth() {
        int width = 80; // Default width
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                Process process = Runtime.getRuntime().exec("cmd /c mode con");
                try (java.util.Scanner scanner = new java.util.Scanner(process.getInputStream())) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("Columns")) {
                            width = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                            break;
                        }
                    }
                }
            } else {
                Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "tput cols 2>/dev/null"});
                try (java.util.Scanner scanner = new java.util.Scanner(process.getInputStream())) {
                    if (scanner.hasNextInt()) {
                        width = scanner.nextInt();
                    }
                }
            }
        } catch (Exception e) {
            width = 80; // Default fallback
        }
        return Math.max(width, 40); // Ensure minimum width
    }
    
    // Method to center text
    private static String centerText(String text, int width) {
        if (text.length() >= width) return text;
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
    
    // Method 1: Simple spinner animation (centered)
    private static void showSpinnerAnimation(String message, int durationMs) {
        String[] spinner = {"|", "/", "-", "\\"};
        long startTime = System.currentTimeMillis();
        int frameIndex = 0;
        int consoleWidth = getConsoleWidth();
        
        try {
            while (System.currentTimeMillis() - startTime < durationMs) {
                String displayText = spinner[frameIndex] + " " + message;
                String centeredText = centerText(displayText, consoleWidth);
                System.out.print("\r" + centeredText);
                frameIndex = (frameIndex + 1) % spinner.length;
                Thread.sleep(100);
            }
            String doneText = "[OK] " + message + " - Done!";
            String centeredDone = centerText(doneText, consoleWidth);
            System.out.println("\r" + centeredDone + " ".repeat(consoleWidth - centeredDone.length()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Method 2: Progress bar animation (centered)
    private static void showProgressBar(String message, int durationMs) {
        int totalWidth = 30;
        long startTime = System.currentTimeMillis();
        int consoleWidth = getConsoleWidth();
        
        try {
            while (System.currentTimeMillis() - startTime < durationMs) {
                int elapsed = (int)(System.currentTimeMillis() - startTime);
                int progress = (elapsed * 100) / durationMs;
                int filledWidth = (progress * totalWidth) / 100;
                
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < totalWidth; i++) {
                    if (i < filledWidth) {
                        bar.append("#");
                    } else if (i == filledWidth) {
                        bar.append(">");
                    } else {
                        bar.append(".");
                    }
                }
                bar.append("] ").append(progress).append("%");
                
                String displayText = message + " " + bar.toString();
                String centeredText = centerText(displayText, consoleWidth);
                System.out.print("\r" + centeredText);
                Thread.sleep(50);
            }
            String doneText = "[OK] " + message + " Complete! [##################################] 100%";
            String centeredDone = centerText(doneText, consoleWidth);
            System.out.println("\r" + centeredDone + " ".repeat(consoleWidth - centeredDone.length()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Method 3: Animated dots (centered)
    private static void showDotsAnimation(String message, int durationMs) {
        long startTime = System.currentTimeMillis();
        int dotCount = 0;
        int consoleWidth = getConsoleWidth();
        
        try {
            while (System.currentTimeMillis() - startTime < durationMs) {
                String displayText = message + " " + ".".repeat(dotCount) + "   ";
                String centeredText = centerText(displayText, consoleWidth);
                System.out.print("\r" + centeredText);
                dotCount = (dotCount % 3) + 1;
                Thread.sleep(400);
            }
            String doneText = "[OK] " + message + " Complete!";
            String centeredDone = centerText(doneText, consoleWidth);
            System.out.println("\r" + centeredDone + " ".repeat(consoleWidth - centeredDone.length()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}