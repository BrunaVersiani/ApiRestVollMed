package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/master
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
<<<<<<< HEAD

    @Autowired
    private UsuarioRepository repository;

=======
    
>>>>>>> origin/master
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

<<<<<<< HEAD
        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
=======
        var subject = tokenService.getSubject(tokenJWT);
        System.out.println(subject);


        filterChain.doFilter(request, response);
>>>>>>> origin/master

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
<<<<<<< HEAD
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
=======
        if(authorizationHeader == null){
            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");
        }
        return authorizationHeader.replace("Bearer ", "");

>>>>>>> origin/master
    }
}
