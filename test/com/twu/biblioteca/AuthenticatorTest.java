package com.twu.biblioteca;

import com.twu.biblioteca.models.UserAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthenticatorTest {

    Authenticator auth;
    UserAccount userExample;

    @Before
    public void setUp() {
        userExample = new UserAccount("789-7890", "xxx");
        auth = Authenticator.getInstance();
        auth.userList.add(userExample);
        auth.logOut();
    }

    @Test
    public void shouldAuthenticateUserWithValidCredentials() {
        auth.authenticateUser("789-7890", "xxx");
        assertEquals(auth.getCurrentLoggedUser(), userExample);
    }

    @Test
    public void shouldNotAuthenticateUserWithInvalidCredentials() {
        auth.authenticateUser("000-0000", "blbla");
        assertNull(auth.getCurrentLoggedUser());
    }

}