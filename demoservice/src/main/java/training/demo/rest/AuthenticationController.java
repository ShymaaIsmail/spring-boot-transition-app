package training.demo.rest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import training.demo.model.jwt.JwtRequest;
import training.demo.model.jwt.JwtResponse;
import training.demo.service.JwtUserDetailsService;
import training.demo.util.JwtTokenUtil;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthenticationController {

    private final JwtUserDetailsService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping("xsrf")
    public ResponseEntity<String> getXSRFToken() {
        return ResponseEntity.ok("");
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> generateJWTToken(@RequestBody JwtRequest authenticationRequest) {
        // Map<String, Object> claims = Map.ofEntries(entry("zoneId", "GMT+3"),
        // entry("uID", "xyz"));
        Map<String, Object> claims = new HashMap<>();

        try {
            // authenticate(authenticationRequest.getUsername(),
            // authenticationRequest.getPassword());
            authenticate("admin", "admin");
        } catch (Exception e) {
            return ResponseEntity.ok(new JwtResponse(e.getMessage()));
        }
        // final UserDetails userDetails =
        // jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername("admin");

        final String token = jwtTokenUtil.generateToken(claims, userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("verify")
    public ResponseEntity<String> verifyJWTToken() {
        return ResponseEntity.ok("kk");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
