package customer.service.crm.Controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customer.service.crm.Service.AppUserDetailService;
import customer.service.crm.io.AuthRequest;
import customer.service.crm.util.JwtUtil;

@RestController
public class authController {

    @Autowired
    private AppUserDetailService appUserDetails;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request, HttpServletResponse response) {
        try {
            authenticate(request.getEmail(), request.getPassword());

            UserDetails userDetails = appUserDetails.loadUserByUsername(request.getEmail());

            // Generate JWT Token
            String token = jwtUtil.generateToken(userDetails);

            // Create HttpOnly Cookie
            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(false); // set true for https
            cookie.setPath("/");
            cookie.setMaxAge(10 * 60 * 60); // 10 hours

            // Add cookie to response
            response.addCookie(cookie);

            // Response Body
            Map<String, Object> success = new HashMap<>();
            success.put("error", false);
            success.put("message", "Login successful");
            success.put("token", token);
            success.put("email", userDetails.getUsername());

            return ResponseEntity.ok(success);

        } catch (BadCredentialsException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("message", "Something went wrong: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    private void authenticate(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    }
}
