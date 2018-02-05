package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {ResourceNames.REST_API, ResourceNames.CONTROLLERS, ResourceNames.DAOS,ResourceNames.SERVICES})
public class WebConfig extends WebMvcConfigurerAdapter {

    // CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(3600);
    }

}


//Seguridad
//@EnableWebSecurity
//@Configuration
//@ComponentScan(basePackages = {ResourceNames.REST_API, ResourceNames.CONTROLLERS, ResourceNames.DAOS,ResourceNames.SERVICES})
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//       http.antMatcher("/**").authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//               .anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
//   }
//}
