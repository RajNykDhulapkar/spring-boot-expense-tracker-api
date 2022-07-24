package com.melodyjumper.expensetrackerapi.services;

import com.melodyjumper.expensetrackerapi.domain.User;
import com.melodyjumper.expensetrackerapi.exceptions.EtAuthException;
import com.melodyjumper.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

    User fetchUserById(Integer userId) throws EtResourceNotFoundException;
}
