package p1;
public class stickMan {
    public static void WalkingStickMan() throws InterruptedException {
    int width = 60;
    
    String[] walkingFrames = {
        " O ",   // Standing
        "/O ",   // Step forward
        " O\\",  // Step back
        " O "    // Standing
    };
    
    // Walk from left to right
    for (int pos = 0; pos <= width; pos++) {
        StringBuilder line = new StringBuilder();
        
        // Add spaces for position
        for (int i = 0; i < pos; i++) line.append(" ");
        
        // Add stick figure with walking animation
        int frameIndex = pos % walkingFrames.length;
        line.append(walkingFrames[frameIndex]);
        
        // Extra spacing to clear previous characters
        for (int i = 0; i < 10; i++) line.append(" ");
        
        System.out.print("\r" + line);
        Thread.sleep(50);
    }
    System.out.println(); // New line after done
}

}

