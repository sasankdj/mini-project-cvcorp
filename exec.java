package p1;

import java.util.Scanner;

public class exec {
    public static void main(String[] args) {
        project.QuizLoomAscii();
        try {
            stickMan.WalkingStickMan();
        } catch (Exception e) {
            // Ignore
        }
        
        try {
            QuizSystem.mainexec();
        } catch (InterruptedException e) {
            // Ignore or log
            e.printStackTrace();
        }
    }    
}