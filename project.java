package p1;
public class project {

public static void quizMenu() {

    // ANSI color codes
    final String RESET  = "\u001B[0m";
    final String RED    = "\u001B[31m";
    final String GREEN  = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE   = "\u001B[34m";
    final String PURPLE = "\u001B[35m";

    // SECTION 1
    System.out.println(RED +
            "  __ _______    _                      _                                               \n" +
            " /_ |__   __|  | |                    (_)                                              \n" +
            "  | |  | | __ _| | _____    __ _ _   _ _ ____                                          \n" +
            "  | |  | |/ _` | |/ / _ \\  / _` | | | | |_  /                                          \n" +
            "  | |_ | | (_| |   <  __/ | (_| | |_| | |/ /                                           \n" +
            "  |_(_)|_|\\__,_|_|\\_\\___|  \\__, |\\__,_|_/___|                                          "
            + RESET);

    // SECTION 2
    System.out.println(GREEN +
            "  ___       _____ _           | |       _____                 _ _                      \n" +
            " |__ \\     / ____| |          |_|      |  __ \\               | | |                     \n" +
            "    ) |   | (___ | |__   _____      __ | |__) |___  ___ _   _| | |_                    \n" +
            "   / /     \\___ \\| '_ \\ / _ \\ \\ /\\ / / |  _  // _ \\/ __| | | | | __|                   \n" +
            "  / /_ _   ____) | | | | (_) \\ V  V /  | | \\ \\  __/\\__ \\ |_| | | |_                    \n" +
            " |____(_) |_____/|_| |_|\\___/ \\_/\\_/   |_|  \\_\\___||___/\\__,_|_|\\__|                   "
            + RESET);

    // SECTION 3
    System.out.println(YELLOW +
            " |___ \\   | |                  | |         |  _ \\                    | |               \n" +
            "   __) |  | |     ___  __ _  __| | ___ _ __| |_) | ___   __ _ _ __ __| |               \n" +
            "  |__ <   | |    / _ \\/ _` |/ _` |/ _ \\ '__|  _ < / _ \\ / _` | '__/ _` |               \n" +
            "  ___) |  | |___|  __/ (_| | (_| |  __/ |  | |_) | (_) | (_| | | | (_| |               \n" +
            " |____(_) |______\\___|\\__,_|\\__,_|\\___|_|  |____/ \\___/ \\__,_|_|  \\__,_|               "
            + RESET);

    // SECTION 4
    System.out.println(BLUE +
            " | || |    / ____|          | | (_)                  | |        | |    |  \\/  |/ ____| \n" +
            " | || |_  | |     ___  _ __ | |_ _ _ __  _   _  ___  | |_ ___   | |    | \\  / | (___   \n" +
            " |__   _| | |    / _ \\| '_ \\| __| | '_ \\| | | |/ _ \\ | __/ _ \\  | |    | |\\/| |\\___ \\  \n" +
            "    | |_  | |___| (_) | | | | |_| | | | | |_| |  __/ | || (_) | | |____| |  | |____) | \n" +
            "  __|_(_)  \\_____\\___/|_| |_|\\__|_|_| |_|\\__,_|\\___|  \\__\\___/  |______|_|  |_|_____/  "
            + RESET);

    // SECTION 5
    System.out.println(PURPLE +
            " | ____|  |  ____|    (_) |                                                            \n" +
            " | |__    | |__  __  ___| |_                                                           \n" +
            " |___ \\   |  __| \\ \\/ / | __|                                                          \n" +
            "  ___) |  | |____ >  <| | |_                                                           \n" +
            " |____(_) |______/_/\\_\\_|\\__|                                                          "
            + RESET);
}
    
public static void lmsMenu(){
   

        String BLUE   = "\u001B[34m";
        String GREEN  = "\u001B[32m";
        String PURPLE = "\u001B[35m";
        String RED    = "\u001B[31m";
        String RESET  = "\u001B[0m";

        System.out.print(

BLUE +
" __      _   _           _     _____ _                 _            \n" +
"/  |    | \\ | |         | |   /  __ \\ |               | |           \n" +
"`| |    |  \\| | _____  _| |_  | /  \\/ |__   __ _ _ __ | |_ ___ _ __ \n" +
" | |    | . ` |/ _ \\ \\/ / __| | |   | '_ \\ / _` | '_ \\| __/ _ \\ '__|\n" +
"_| |__  | |\\  |  __/>  <| |_  | \\__/\\ | | | (_| | |_) | ||  __/ |   \n" +
"\\___(_) \\_| \\_/\\___/_/\\_\\\\__|  \\____/_| |_|\\__,_| .__/ \\__\\___|_|   \n" +
"                                                | |                 \n" +
"                                                |_|                 \n" +

GREEN +
" _____     _   _           _     _____           _                  \n" +
"/ __  \\   | \\ | |         | |   |_   _|         (_)                 \n" +
"`' / /'   |  \\| | _____  _| |_    | | ___  _ __  _  ___             \n" +
"  / /     | . ` |/ _ \\ \\/ / __|   | |/ _ \\| '_ \\| |/ __|            \n" +
"./ /____  | |\\  |  __/>  <| |_    | | (_) | |_) | | (__             \n" +
"\\_____(_) \\_| \\_/\\___/_/\\_\\\\__|   \\_/\\___/| .__/|_|\\___|            \n" +
"                                          | |                      \n" +
"                                          |_|                      \n" +

PURPLE +
" _____    _____     _          _____       _                        \n" +
"|____ |  |_   _|   | |        |  _  |     (_)                       \n" +
"    / /    | | __ _| | _____  | | | |_   _ _ ____                   \n" +
"    \\ \\    | |/ _` | |/ / _ \\ | | | | | | | |_  /                   \n" +
".___/ /    | | (_| |   <  __/ \\ \\'/ / |_| | |/ /                    \n" +
"\\____(_)   \\_/\\__,_|_|\\_\\___|  \\_/\\_\\\\__,_|_/___|                   \n" +
"                                                                    \n" +
"                                                                    \n" +

RED +
"   ___     _____     _ _                                            \n" +
"  /   |   |  ___|   (_) |                                           \n" +
" / /| |   | |____  ___| |_                                          \n" +
"/ /_| |   |  __\\ \\/ / | __|                                         \n" +
"\\___  |_  | |___>  <| | |_                                          \n" +
"    |_(_) \\____/_/\\_\\_|\\__|                                         \n" +
"                                                                    \n" +

RESET
        );
    } 
    public static void banner1() {

    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String CYAN = "\u001B[36m";
    String RESET = "\u001B[0m";

    // SECTION 1
    System.out.print(
        RED +
        "   ___     _____ _                       \n" +
        "  <  /    / ___/(_)___ _____  __  ______\n" +
        "  / /     \\__ \\/ / __ `/ __ \\/ / / / __ \\\n" +
        " / /     ___/ / / /_/ / / / / /_/ / /_/ /\n" +
        "/_(_)   /____/_/\\__, /_/ /_/\\__,_/ .___/ \n" +
        "   ___        _/____/           /_/      \n" +
        RESET
    );

    // SECTION 2
    System.out.print(
        GREEN +
        "  |__ \\      / /   ____  ____ _(_)___    \n" +
        "  __/ /     / /   / __ \\/ __ `/ / __ \\   \n" +
        " / __/_    / /___/ /_/ / /_/ / / / / /   \n" +
        "/____(_)  /_____/\\____/\\__, /_/_/ /_/    \n" +
        "   _____      ______  /____/_            \n" +
        RESET
    );

    // SECTION 3
    System.out.print(
        CYAN +
        "  |__  /     / ____/  __(_) /_           \n" +
        "   /_ <     / __/ | |/_/ / __/           \n" +
        " ___/ /    / /____>  </ / /_             \n" +
        "/____(_)  /_____/_/|_/_/\\__/             \n" +
        "                                         \n" +
        RESET
    );
}

    public static void quizManagement() {

        System.out.print(
"  /$$$$$$            /$$                 /$$      /$$                                                                                       /$$    \n" +
" /$$__  $$          |__/                | $$$    /$$$                                                                                      | $$    \n" +
"| $$  \\ $$ /$$   /$$ /$$ /$$$$$$$$      | $$$$  /$$$$  /$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$/$$$$   /$$$$$$  /$$$$$$$  /$$$$$$  \n" +
"| $$  | $$| $$  | $$| $$|____ /$$/      | $$ $$/$$ $$ |____  $$| $$__  $$ |____  $$ /$$__  $$ /$$__  $$| $$_  $$_  $$ /$$__  $$| $$__  $$|_  $$_/  \n" +
"| $$  | $$| $$  | $$| $$   /$$$$/       | $$  $$$| $$  /$$$$$$$| $$  \\ $$  /$$$$$$$| $$  \\ $$| $$$$$$$$| $$ \\ $$ \\ $$| $$$$$$$$| $$  \\ $$  | $$    \n" +
"| $$/$$ $$| $$  | $$| $$  /$$__/        | $$\\  $ | $$ /$$__  $$| $$  | $$ /$$__  $$| $$  | $$| $$_____/| $$ | $$ | $$| $$_____/| $$  | $$  | $$ /$$\n" +
"|  $$$$$$/|  $$$$$$/| $$ /$$$$$$$$      | $$ \\/  | $$|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$ | $$ | $$|  $$$$$$$| $$  | $$  |  $$$$/\n" +
" \\____ $$$ \\______/ |__/|________/      |__/     |__/ \\_______/|__/  |__/ \\_______/ \\____  $$ \\_______/|__/ |__/ |__/ \\_______/|__/  |__/   \\___/  \n" +
"      \\__/                                                                          /$$  \\ $$                                                      \n" +
"                                                                                   |  $$$$$$/                                                      \n" +
"                                                                                    \\______/                                                       \n"
        );

    }
    public static void python() {

        System.out.print(
"   _ (`-.               .-') _    ('-. .-.                  .-') _  \n" +
"  ( (OO  )             (  OO) )  ( OO )  /                 ( OO ) ) \n" +
" _.`     \\  ,--.   ,--./     '._ ,--. ,--. .-'),-----. ,--./ ,--,'  \n" +
"(__...--''   \\  `.'  / |'--...__)|  | |  |( OO'  .-.  '|   \\ |  |\\  \n" +
" |  /  | | .-')     /  '--.  .--'|   .|  |/   |  | |  ||    \\|  | ) \n" +
" |  |_.' |(OO  \\   /      |  |   |       |\\_) |  |\\|  ||  .     |/  \n" +
" |  .___.' |   /  /\\_     |  |   |  .-.  |  \\ |  | |  ||  |\\    |   \n" +
" |  |      `-./  /.__)    |  |   |  | |  |   `'  '-'  '|  | \\   |   \n" +
" `--'        `--'         `--'   `--' `--'     `-----' `--'  `--'   \n"
        );

    }
    public static void java() {

        System.out.print(
"\n" +
"        (               (      \n" +
"   (    )\\     (   (    )\\     \n" +
"   )\\((((_)(   )\\  )\\((((_)(   \n" +
"  ((_))\\ _ )\\ ((_)((_))\\ _ )\\  \n" +
" _ | |(_)_\\(_)\\ \\ / / (_)_\\(_) \n" +
"| || | / _ \\   \\ V /   / _ \\   \n" +
" \\__/ /_/ \\_\\   \\_/   /_/ \\_\\  \n" +
"\n"
        );

    }
    public static void chooseSubjectBanner() {

    String CYAN = "\u001B[36m";
    String RESET = "\u001B[0m";

    System.out.print(
        CYAN +
        "   _____ _                                        _____       _     _           _   \n" +
        "  / ____| |                              /\\      / ____|     | |   (_)         | |  \n" +
        " | |    | |__   ___   ___  ___  ___     /  \\    | (___  _   _| |__  _  ___  ___| |_ \n" +
        " | |    | '_ \\ / _ \\ / _ \\/ __|/ _ \\   / /\\ \\    \\___ \\| | | | '_ \\| |/ _ \\/ __| __|\n" +
        " | |____| | | | (_) | (_) \\__ \\  __/  / ____ \\   ____) | |_| | |_) | |  __/ (__| |_ \n" +
        "  \\_____|_| |_|\\___/ \\___/|___/\\___| /_/    \\_\\ |_____/ \\__,_|_.__/| |\\___|\\___|\\__|\n" +
        "                                                                  _/ |              \n" +
        "                                                                 |__/               \n" +
        RESET
    );
}
    public static void theLms() {

        System.out.println("  _____    _   _  U _____ u       _      __  __    ____     ");
        System.out.println(" |_ \" _|  |'| |'| \\| ___\"|/      |\"|   U|' \\/ '|u / __\"| u  ");
        System.out.println("   | |   /| |_| |\\ |  _|\"      U | | u \\| |\\/| |/<\\___ \\/   ");
        System.out.println("  /| |\\  U|  _  |u | |___       \\| |/__ | |  | |  u___) |   ");
        System.out.println(" u |_|U   |_| |_|  |_____|       |_____||_|  |_|  |____/>>  ");
        System.out.println(" _// \\\\_  //   \\\\  <<   >>       //  \\\\<<,-,,-.    )(  (__) ");
        System.out.println("(__) (__)(_\" ) (\"_)(__) (__)     (_\")(_)(./  \\.)  (__)      ");
    }
    static void fromConsoleToPapers(){
         System.out.print(
" _____ ____  ____  _        ____  ____  ____  _____ ____  ____    _____ ____    ____  ____  _      ____  ____  _     _____\n" +
"/    //  __\\/  _ \\/ \\__/|  /  __\\/  _ \\/  __\\/  __//  __\\/ ___\\  /__ __Y  _ \\  /   _\\/  _ \\/ \\  /|/ ___\\/  _ \\/ \\   /  __/\n" +
"|  __\\|  \\/|| / \\|| |\\/||  |  \\/|| / \\||  \\/||  \\  |  \\/||    \\    / \\ | / \\|  |  /  | / \\|| |\\ |||    \\| / \\|| |   |  \\  \n" +
"| |   |    /| \\_/|| |  ||  |  __/| |-|||  __/|  /_ |    /\\___ |    | | | \\_/|  |  \\__| \\_/|| | \\||\\___ || \\_/|| |_\\/|  /_ \n" +
"\\_/   \\_/\\_\\\\____/\\_/  \\|  \\_/   \\_/ \\|\\_/   \\____\\\\_/\\_\\\\____/    \\_/ \\____/  \\____/\\____/\\_/  \\|\\____/\\____/\\____/\\____\\\n"
        );
    }
    public static void intro(){
        
String CYAN = "\u001B[36m";
       
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE = "\u001B[34m";

        String RESET = "\u001B[0m";
         
 System.out.print(
        CYAN +
        "   _____ _                                        _____       _     _           _   \n" +
        "  / ____| |                              /\\      / ____|     | |   (_)         | |  \n" +
        " | |    | |__   ___   ___  ___  ___     /  \\    | (___  _   _| |__  _  ___  ___| |_ \n" +
        " | |    | '_ \\ / _ \\ / _ \\/ __|/ _ \\   / /\\ \\    \\___ \\| | | | '_ \\| |/ _ \\/ __| __|\n" +
        " | |____| | | | (_) | (_) \\__ \\  __/  / ____ \\   ____) | |_| | |_) | |  __/ (__| |_ \n" +
        "  \\_____|_| |_|\\___/ \\___/|___/\\___| /_/    \\_\\ |_____/ \\__,_|_.__/| |\\___|\\___|\\__|\n" +
        "                                                                  _/ |              \n" +
        "                                                                 |__/               \n" +
        RESET
    );
        // Section 1
    System.out.println(RED +
            "  __         __   __   _  _   __                         \n" +
            " /  \\      _(  ) / _\\ / )( \\ / _\\                        \n" +
            "(_/ / _   / \\) \\/    \\\\ \\/ //    \\                       \n" +
            " (__)(_)  \\____/\\_/\\_/ \\__/ \\_/\\_/                       "
            + RESET);

    // Section 2
    System.out.println(GREEN +
            " ____       ____  _  _  ____  _  _   __   __ _           \n" +
            "(___ \\     (  _ \\( \\/ )(_  _)/ )( \\ /  \\ (  ( \\          \n" +
            " / __/ _    ) __/ )  /   )(  ) __ ((  O )/    /          \n" +
            "(____)(_)  (__)  (__/   (__) \\_)(_/ \\__/ \\_)__)         "
            + RESET);

    // Section 3
    System.out.println(YELLOW +
            " ____        __   ____  ____  __  ____  _  _  ____  ____ \n" +
            "( __ \\      / _\\ (  _ \\(_  _)(  )(_  _)/ )( \\(    \\(  __)\n" +
            " (__ ( _   /    \\ ) __/  )(   )(   )(  ) \\/ ( ) D ( ) _) \n" +
            "(____/(_)  \\_/\\_/(__)   (__) (__) (__) \\____/(____/(____)"
            + RESET);

    // Section 4
    System.out.println(BLUE +
            "  ___       ____  _  _  __  ____                         \n" +
            " / _ \\     (  __)( \\/ )(  )(_  _)                        \n" +
            "(__  ( _    ) _)  )  (  )(   )(                          \n" +
            "  (__/(_)  (____)(_/_\\_)(__) (__)                        "
            + RESET);

        
    }
    public static void learn() {

    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String CYAN = "\u001B[36m";
    String RESET = "\u001B[0m";

    // SECTION 1
    System.out.print(
        RED +
        " _       __                                         \n" +
        "/ |     / /  ___  __ _ _ __ _ __                   \n" +
        "| |    / /  / _ \\/ _` | '__| '_ \\                  \n" +
        "| |_  / /__|  __/ (_| | |  | | | |                 \n" +
        "|_(_) \\____/\\___|\\__,_|_|  |_| |_|                 \n" +
        "                                                    \n" +
        RESET
    );

    // SECTION 2
    System.out.print(
        GREEN +
        " ____      _____      _            ____       _     \n" +
        "|___ \\    /__   \\__ _| | _____    /___ \\_   _(_)____\n" +
        "  __) |     / /\\/ _` | |/ / _ \\  //  / / | | | |_  /\n" +
        " / __/ _   / / | (_| |   <  __/ / \\_/ /| |_| | |/ / \n" +
        "|_____(_)  \\/   \\__,_|_|\\_\\___| \\___,_\\\\__,_|_/___|\n" +
        "                                                     \n" +
        RESET
    );

    // SECTION 3
    System.out.print(
        CYAN +
        " _____      __      _ _                             \n" +
        "|___ /     /__\\_  _(_) |_                           \n" +
        "  |_ \\    /_\\ \\ \\/ / | __|                          \n" +
        " ___) |  //__  >  <| | |_                           \n" +
        "|____(_) \\__/ /_/\\_\\_|\\__|                          \n" +
        "                                                     \n" +
        RESET
    );
}
public static void QuizLoomAscii() {
    // ANSI Color Codes
    final String RESET = "\u001B[0m";

    final String BLACK = "\u001B[30m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE = "\u001B[34m";
    final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";
    final String WHITE = "\u001B[37m";

    final String BRIGHT_BLUE = "\u001B[94m";
    final String BRIGHT_PURPLE = "\u001B[95m";
    final String BRIGHT_CYAN = "\u001B[96m";
    final String BRIGHT_YELLOW = "\u001B[93m";

    // Logo Symbol
    System.out.println(BRIGHT_PURPLE + "                                                            mda0099990bj");
    System.out.println(BRIGHT_PURPLE + "                                                         faaa0099988887766c");
    System.out.println(BRIGHT_PURPLE + "                                                      yd009099998887776665557x");
    System.out.println(BRIGHT_PURPLE + "                                                     m88888888jox  yok66555444j     x05e");
    System.out.println(BRIGHT_BLUE +   "                                                    f777667d            b444333f   755i");
    System.out.println(BRIGHT_BLUE +   "                                                   o665556     uXUUWu     422222f  xt");
    System.out.println(BRIGHT_BLUE +   "                                                   554444s   wTTTTSSSSt   z111113");
    System.out.println(BRIGHT_CYAN +   "                                                  l333334    cSTy  jRRj    8ZZZZZo  zjjlmny");
    System.out.println(BRIGHT_CYAN +   "                                                  h222216        s2RQQ     dZZZZZo  zpoprsz");
    System.out.println(BRIGHT_CYAN +   "                                                  t111111       vQQYy      ZYYYYYr");
    System.out.println(BRIGHT_YELLOW + "                                                   2ZZZYYe       uv       9XXXXX1  xqx");
    System.out.println(BRIGHT_YELLOW + "                                                   zZYYYXX2     sPPp y0997YUVWWY   pcccr");
    System.out.println(BRIGHT_BLUE +   "                                                    vXXXXWWW1y      z0988776YUUs     wff");
    System.out.println(BRIGHT_BLUE +   "                                                      3XWWWWVVVUTTTRPZ87766544f");
    System.out.println(BRIGHT_PURPLE + "                                                       vYWVVVVUUUUTRPONV65443322d");
    System.out.println(BRIGHT_PURPLE + "                                                          kXUVVUUTTSRQPNQf5322211m");
    System.out.println(BRIGHT_PURPLE + "                                                              rmgccfkq     p31111w");
    System.out.println(WHITE +         "                                                                              y");

    // QUIZLOOM Text
    System.out.println(BLUE +          "                             kQFFFRl               dFHy           cas");
    System.out.println(BLUE +          "                           KFFGMRMGFFZ              U5            22m");
    System.out.println(BLUE +          "                          NFG      rFFL  KJs   JJZ qJK  PJJJJJJc  11m        y42229     z3333a   v42 533f g335q");
    System.out.println(PURPLE +       "                         oFFi       9FFl FFm   FFR mFGy okllJFFp  ZZm       3ZZiw0ZZe  41Zgx011d u211qo2116ue22c");
    System.out.println(PURPLE +       "                         uFF0    bl TFGo FFn   FFR mFGy   vKFY    YYl      gY1    vZ1yjZ3    wZ1zu21z  h11   422");
    System.out.println(BRIGHT_PURPLE +"                          1EF2  sMFFFFY  GFc  rFFR mFGy  VFIq     XXk      pXXz   bY3 rYYx   eZ2 t1Z   h11   422");
    System.out.println(BRIGHT_BLUE +  "                           lKFFFFFFEEJq  XFFFFFFFR mFGyrHFFFFGFL  WWWWWWWWw fXXXXWX1x  iYYYYYY1w tZZz  h11   422");
    System.out.println(CYAN +          "                              zb2b  kIF4   l0x  z   z    zzzzzz                ohw        qiv");

    // Footer
    System.out.println("\n" + BRIGHT_YELLOW + "                                                QUIZLOOM - Learn, Play, Grow!" + RESET);
}
}

