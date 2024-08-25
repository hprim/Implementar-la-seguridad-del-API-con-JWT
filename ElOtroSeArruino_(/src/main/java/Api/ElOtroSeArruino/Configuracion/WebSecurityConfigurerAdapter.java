package Api.ElOtroSeArruino.Configuracion;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(AuthenticationManagerBuilder auth) throws Exception;

    protected abstract void configure(HttpSecurity http) throws Exception;

    @Bean
    public abstract AuthenticationManager authenticationManagerBean() throws Exception;
}
