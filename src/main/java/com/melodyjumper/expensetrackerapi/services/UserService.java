package com.melodyjumper.expensetrackerapi.services;

import com.melodyjumper.expensetrackerapi.domain.User;
import com.melodyjumper.expensetrackerapi.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
