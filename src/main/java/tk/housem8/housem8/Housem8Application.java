package tk.housem8.housem8;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import tk.housem8.housem8.entities.Commerce;
import tk.housem8.housem8.entities.Cost;
import tk.housem8.housem8.entities.CostFamily;
import tk.housem8.housem8.entities.CostRest;
import tk.housem8.housem8.entities.House;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.entities.Room;
import tk.housem8.housem8.entities.RoomClass;
import tk.housem8.housem8.repos.MateRepository;

@Configuration
@ComponentScan
@SpringBootApplication
public class Housem8Application {

    public static void main(String[] args) {
        SpringApplication.run(Housem8Application.class, args);

    }
}

@Configuration
class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Mate.class);
        config.exposeIdsFor(House.class);
        config.exposeIdsFor(Room.class);
        config.exposeIdsFor(RoomClass.class);
        config.exposeIdsFor(Cost.class);
        config.exposeIdsFor(CostRest.class);
        config.exposeIdsFor(Commerce.class);
        config.exposeIdsFor(CostFamily.class);
    }
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    MateRepository mateRepository;
   
    
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                System.out.println("Mate");
                Mate mate = new Mate();
                System.out.println("repo mate");

                mate = mateRepository.findByEmail(email);

                if (mate != null) {

                    return new User(mate.getEmail(), mate.getPass(), mate.isActivo(), true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + email + "'");
                }
            }
        };
    }
}

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        /*
        http.authorizeRequests().antMatchers("/")
                .permitAll().anyRequest().authenticated();
        //http.formLogin().loginPage("/login").permitAll();
        //http.logout().logoutUrl("/logout").permitAll();
        //http.logout().logoutSuccessUrl("/login").deleteCookies("JSESSIONID");
        http.httpBasic().and()
                .csrf().disable().anonymous()
                .and()
                .sessionManagement().maximumSessions(3);
        */
          http.authorizeRequests().anyRequest().fullyAuthenticated().and().
                  
    httpBasic().and().
    csrf().disable().anonymous()
                  .and()
                .sessionManagement().maximumSessions(4);
                  ;
        

    }
    /*
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.getDefaultUserDetailsService();
		// @formatter:on
	}
*/
	

}
