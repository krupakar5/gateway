package app.net.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 *
 * @author Chirag Sardhara
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {

  /** The environment. */
  @Autowired
  private Environment environment;
  /** The spring profile val for active profile based on env. */
  private static final String SPRING_PROFILE_VALUE = "spring.profiles.active";

  /** The Constant PROFILE_VALUE. */
  private static final List<String> PROFILE_VALUE = Arrays.asList("DEV", "TEST");

  /**
   * UiConfiguration method.
   *
   * @return UiConfiguration
   */
  @Bean
  public UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder().validatorUrl("validatorUrl")
        .docExpansion(DocExpansion.LIST).tagsSorter(TagsSorter.ALPHA)
        .defaultModelRendering(ModelRendering.MODEL).showExtensions(true)
        .displayRequestDuration(true).build();
  }

  /**
   * Api.
   *
   * @return the docket
   */
  @Bean
  public Docket api() {
    if (PROFILE_VALUE.stream().anyMatch(x -> x.equalsIgnoreCase(
        environment.getRequiredProperty(SPRING_PROFILE_VALUE)))) {
      return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("app.net")).build();
    } else {
      return null;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
   * addResourceHandlers(org.springframework.web.servlet.config.annotation.
   * ResourceHandlerRegistry)
   */
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    if (PROFILE_VALUE.stream().anyMatch(x -> x.equalsIgnoreCase(
        environment.getRequiredProperty(SPRING_PROFILE_VALUE)))) {
      registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");

      registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  }

}
