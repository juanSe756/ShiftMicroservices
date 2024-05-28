package co.edu.uptc.redirectservice.application.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;

@RestController
public class RoleRedirectController {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private String getRoleFromAuthentication(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.startsWith("ROLE_"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No role found in authentication"));
    }
    @GetMapping("/redirect")
    public void redirect(Authentication authentication) throws IOException {
        String role = getRoleFromAuthentication(authentication);
        if (role.equals("ROLE_ADMIN")) {
            redirectStrategy.sendRedirect(null, null, "http://localhost:4200/admin");
        } else if (role.equals("ROLE_USER")) {
            redirectStrategy.sendRedirect(null, null, "http://localhost:4200/user");
        } else {
            redirectStrategy.sendRedirect(null, null, "http://localhost:4200/error");
        }
    }

}
