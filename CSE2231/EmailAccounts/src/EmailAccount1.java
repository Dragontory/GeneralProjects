import components.map.Map;
import components.map.Map1L;

/**
 * Implementation of {@code EmailAccount}.
 *
 * @author Put your name here
 *
 */
public final class EmailAccount1 implements EmailAccount {

    /*
     * Private members --------------------------------------------------------
     */

    // TODO - declare static and instance data members
    /**
     * String to hold the first name.
     */
    private String firstName;

    /**
     * String to hold the last name.
     */
    private String lastName;

    /**
     * String to hold the email address.
     */
    private String email;

    /**
     * Map to hold last names with their dot numbers.
     */
    private static Map<String, Integer> number = new Map1L<String, Integer>();

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * Constructor.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public EmailAccount1(String firstName, String lastName) {

        // TODO - fill in body
        this.firstName = firstName;
        this.lastName = lastName;

        String lowerLastName = lastName.toLowerCase();

        if (!number.hasKey(lowerLastName)) {

            number.add(lowerLastName, 1);

        } else {

            int temp = number.value(lowerLastName);
            number.replaceValue(lowerLastName, ++temp);
        }

        this.email = lowerLastName + "."
                + Integer.toString(number.value(lowerLastName)) + "@osu.edu";

    }

    /*
     * Methods ----------------------------------------------------------------
     */

    @Override
    public String name() {

        // TODO - fill in body

        String name = this.firstName + " " + this.lastName;

        return name;
    }

    @Override
    public String emailAddress() {

        // TODO - fill in body

        return this.email;
    }

    @Override
    public String toString() {

        // TODO - fill in body

        return "Name: " + this.firstName + " " + this.lastName + ", "
                + "Email: " + this.email;
    }

}
