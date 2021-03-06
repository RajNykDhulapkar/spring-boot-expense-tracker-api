package com.melodyjumper.expensetrackerapi.resources;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.lang.String;

import com.melodyjumper.expensetrackerapi.Constants;
import com.melodyjumper.expensetrackerapi.domain.User;
import com.melodyjumper.expensetrackerapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> loginMap) {
        String email = (String) loginMap.get("email");
        String password = (String) loginMap.get("password");
        User user = userService.validateUser(email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(firstName, lastName, email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentLoggedInUser(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        User user = userService.fetchUserById(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getUserId());
        map.put("firstName", user.getFirstName());
        map.put("lastName", user.getLastName());
        map.put("email", user.getEmail());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}
