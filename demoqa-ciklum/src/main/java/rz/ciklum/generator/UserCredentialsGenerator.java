package rz.ciklum.generator;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Generator of random usernames
 */
public class UserCredentialsGenerator {

    public String createUsername(String firstName, String lastName, int usernameLength) {
        int basicUsernameLength = (firstName + lastName).length();
        String fullUsername = (firstName + lastName + RandomStringUtils.randomNumeric(usernameLength - basicUsernameLength)).toUpperCase();
        return fullUsername;
    }

    public String createPassword(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
