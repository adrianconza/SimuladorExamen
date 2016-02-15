package ec.com.simuladorexamen.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ec.com.simuladorexamen.utilidades.Conexion;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:database.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/javax.faces.resource/**", "/resources/**", "/views/publicas/**").permitAll()

				.antMatchers("/views/privadas/home.jsf").access("isAuthenticated()")

				.antMatchers("/views/privadas/calificacion.jsf").hasAnyAuthority("ESTU")
				.antMatchers("/views/privadas/simuladoExamen.jsf").hasAnyAuthority("ESTU")

				.and().formLogin().loginPage("/views/publicas/login.jsf").defaultSuccessUrl("/views/privadas/home.jsf")

				.and().logout().logoutUrl("/views/publicas/logout.jsf").logoutSuccessUrl("/views/publicas/login.jsf")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID")

				.and().exceptionHandling().accessDeniedPage("/views/publicas/access-denied.jsf")

				.and().sessionManagement().invalidSessionUrl("/views/publicas/login.jsf").maximumSessions(1);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource()).passwordEncoder(new ShaPasswordEncoder(256))
				.usersByUsernameQuery(getUserQuery()).authoritiesByUsernameQuery(getAuthoritiesQuery());
	}

	@Bean
	public DataSource dataSource() {
		Conexion.iniciarConeccion("postgresql", "org.postgresql.Driver", env.getProperty("jdbc.server"),
				env.getProperty("jdbc.port"), env.getProperty("jdbc.database"), env.getProperty("jdbc.user"),
				env.getProperty("jdbc.password"));

		Conexion conexion = Conexion.getConexion();

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(conexion.getDriver());
		dataSource.setUrl("jdbc:" + conexion.getDb() + "://" + conexion.getServer() + ":" + conexion.getPort() + "/"
				+ conexion.getDatabase());
		dataSource.setUsername(conexion.getUser());
		dataSource.setPassword(conexion.getPassword());

		return dataSource;
	}

	private String getAuthoritiesQuery() {
		return "select distinct u.email, u.rol from \"simuladorExamen\".usuarios u where u.email=LOWER(?)";
	}

	private String getUserQuery() {
		return "select u.email, u.password, true from \"simuladorExamen\".usuarios u where u.email=LOWER(?)";
	}
}
