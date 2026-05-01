package p1;
public class MeetLoaderStyles {

    // Style 1 : Arrow Fighters
    public static void arrowFight() throws InterruptedException {
        int width = 40;
        for (int step = 0; step <= width / 2; step++) {
            StringBuilder line = new StringBuilder();

            for (int i = 0; i < step; i++) line.append(" ");

            if (step == width / 2) {
                line.append(">>X<<");
            } else {
                line.append(">>>");
                for (int i = 0; i < width - (step * 2); i++) line.append(" ");
                line.append("<<<");
            }

            line.append("                                                  ");
            System.out.print("\r" + line);
            Thread.sleep(80);
        }
        System.out.println();
    }

    // Style 2 : Knights
    public static void knightMeet() throws InterruptedException {
        int width = 40;
        for (int step = 0; step <= width / 2; step++) {
            StringBuilder line = new StringBuilder();

            for (int i = 0; i < step; i++) line.append(" ");

            if (step == width / 2) {
                line.append("/\\||/\\\\");
            } else {
                line.append("/\\");
                for (int i = 0; i < width - (step * 2); i++) line.append(" ");
                line.append("/\\");
            }

            line.append("                                                  ");
            System.out.print("\r" + line);
            Thread.sleep(90);
        }
        System.out.println();
    }

    // Style 3 : Robots
    public static void robotMeet() throws InterruptedException {
        int width = 40;
        for (int step = 0; step <= width / 2; step++) {
            StringBuilder line = new StringBuilder();

            for (int i = 0; i < step; i++) line.append(" ");

            if (step == width / 2) {
                line.append("[#][#]");
            } else {
                line.append("[>");
                for (int i = 0; i < width - (step * 2); i++) line.append(" ");
                line.append("<]");
            }

            line.append("                                                  ");
            System.out.print("\r" + line);
            Thread.sleep(85);
        }
        System.out.println();
    }

    // Style 4 : Stick Men
    public static void stickMeet() throws InterruptedException {
        int width = 40;
        for (int step = 0; step <= width / 2; step++) {
            StringBuilder line = new StringBuilder();

            for (int i = 0; i < step; i++) line.append(" ");

            if (step == width / 2) {
                line.append("o/\\o");
            } else {
                line.append("o>");
                for (int i = 0; i < width - (step * 2); i++) line.append(" ");
                line.append("<o");
            }

            line.append("                                                  ");
            System.out.print("\r" + line);
            Thread.sleep(100);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        arrowFight();
        Thread.sleep(500);

        knightMeet();
        Thread.sleep(500);

        robotMeet();
        Thread.sleep(500);

        stickMeet();
    }
}