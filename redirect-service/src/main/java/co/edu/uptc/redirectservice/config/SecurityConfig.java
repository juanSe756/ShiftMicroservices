package co.edu.uptc.redirectservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//@RequiredArgsConstructor
public class SecurityConfig {

//    private final JwtAuthenticationConverter jwtAuthenticationConverter;
//    @Autowired
//    public SecurityConfig(JwtAuthenticationConverter jwtAuthenticationConverter) {
//        this.jwtAuthenticationConverter = jwtAuthenticationConverter;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(http -> {
                    http.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth -> {
                    oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter()));
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthConverter() {
        org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter converter = new org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());

        return converter;
    }
}

@SuppressWarnings("unchecked")
class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>>{
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        if (jwt.getClaims() == null){
            return List.of();
        }

        final Map<String, List<String>> realmAccess = (Map<String, List<String>>) jwt.getClaims().get("realm_access");

        return realmAccess.get("roles").stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
