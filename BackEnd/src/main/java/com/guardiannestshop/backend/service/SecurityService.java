package com.guardiannestshop.backend.service;

import com.guardiannestshop.backend.dto.*;

public interface SecurityService {
    UserDTO signinAdmin(String username, String password);
    UserDTO signinUser(String username, String password);
    void signup(UserDTO userDTO );
    UserDTO profile(String userid);

}
