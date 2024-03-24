import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple program to exercise EmailAccount functionality.
 */
public final class EmailAccountMain {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private EmailAccountMain() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
//        EmailAccount myAccount = new EmailAccount1("Brutus", "Buckeye");
//        /*
//         * Should print: Brutus Buckeye
//         */
//        out.println(myAccount.name());
//        /*
//         * Should print: buckeye.1@osu.edu
//         */
//        out.println(myAccount.emailAddress());
//        /*
//         * Should print: Name: Brutus Buckeye, Email: buckeye.1@osu.edu
//         */
//        out.println(myAccount);

        Queue<String> q = new Queue1L();

        out.println("Enter a full name: ");
        String input = in.nextLine();

        while (input != "") {
            String[] name = input.split(" ");

            EmailAccount myAccount = new EmailAccount1(name[0], name[1]);

            String email = myAccount.toString();

            q.enqueue(email);

            out.println(q);

            out.println("Enter a full name: ");
            input = in.nextLine();
        }

        out.println(q);

        in.close();
        out.close();
    }

}
