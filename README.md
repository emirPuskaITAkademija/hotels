# Getting Started

### Tehnologije korištene u aplikaciji
* Thymeleaf
* Spring Security
* Spring MVC
* Spring Data JPA
* MySQL DB

### Arhitektura aplikacije 
 * tradicionalni pristup Spring MVC - multi page not SPA
 * Spring Boot - RAD(Rapid App Dev)
### Kako konfigurisati Spring Security ? 
#### Goruća pitanja
1. Kako koristiti svoj login.html ? 
2. Kako dodati logout opciju ? 
3. Kako dodati register.html ? 
4. Kako natjerati Spring da priča sa našom user/User tabelom u bazi ? 

#### Odgoovori 
1. Kako koristiti svoj login.html ? 
   * src/main/resources/templates/login.html
   * UserController @GetMapping /login
   * mapirati UserDetails(Spring) <-> UserDetailsAdapter
     *  UserDetailsAdapter extends UserDetails
     *  UserDetailsAdapter ima konstruktor koji prima User instancu našu
   * mapirati UserDetailsService <-> UserDetailsAdapter
     * CustomUserDetailsService extends UserDetailsService
     * override method loginByUsername 
     * u implementaciji metode ima vezu na naš UserRepository
   * Reći Springu koji smo hashing alg odabrali
     * BCryptPasswordEncoder
   * Nakon toga reći kako radimo authentication kroz SecurityConfig:
     * DaoAuthenticationProvider ->(BCryptPasswordEncoder, UserDetailsService)
   * Naravno SecurityConfig mora dopustiti sve /login, /register da budu isporučene bez authentikacije
2. Logout opcija je poprilično jednostavna i dodaje se u dva koraka:
   * SecurityConfig postavka
   * HTML link koji ide ka /logout putanji 
3. Jednostavno dizajnirati register.html
    * Kreirati kontroller metodu koja će servirati register.html
    * Kreirati kontroller metodu koja će na POST prihvatiti user objekat i hashirati lozinku i perzistati ga u bazu
4. Objašnjeno kroz korak 1

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.0/maven-plugin/build-image.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

