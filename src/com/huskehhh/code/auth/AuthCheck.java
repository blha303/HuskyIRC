package com.huskehhh.code.auth;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.User;

public class AuthCheck {

    /**
     * Gets whether or not the user is Authenticated with NickServ.
     *
     * @param user user in question.
     * @return user is authenticated.
     */

    public static boolean authCheck(String user) {
        User inQ = HuskyIRC.bot.getUser(user);

        return inQ.isVerified();
    }

}
