/**
 * package declaration
 */
package app.net;

/**
 * import statements
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.context.config.annotation.EnableContextInstanceData;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.stagemonitor.core.Stagemonitor;

import app.net.filters.PostFilter;
import app.net.filters.PreFilter;
import app.net.utils.AppConstants;

/**
 * The Class GatewayServerApplication.
 *
 * @author chirags
 */
@EnableDiscoveryClient
@EnableZuulProxy
@EnableCircuitBreaker
@SpringBootApplication
@EnableContextInstanceData
// @EnableAsync
// @EnableHystrix
public class GatewayServerApplication {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LogManager.getLogger(GatewayServerApplication.class);

  /**
   * The main method.
   *
   * @param args
   *          the arguments
   */
  public static void main(final String[] args) {

    // Load default environment as local, if not pass any argument
    String env = AppConstants.DEFAULT_ENV;

    // set environment
    if (args.length > 0) {
      LOGGER.info("Environment based argument is :- " + args[0]);
      env = args[0];
    }

    // Load environment based upon pass arguments
    loadEnvironment(env);
    LOGGER.info("Current Environment is :- " + env);
    Stagemonitor.init();
    SpringApplication.run(GatewayServerApplication.class, args);
  }

  /**
   * Load environment.
   *
   * @param env
   *          the env
   */
  private static void loadEnvironment(final String env) {
    System.setProperty(AppConstants.SPRING_ACTIVE_PROFILE_PROPERTY_NAME, env.toUpperCase());
  }

  /**
   * Pre filter.
   *
   * @return the pre filter
   */
  @Bean
  public PreFilter preFilter() {
    return new PreFilter();
  }

  /**
   * Post filter.
   *
   * @return the post filter
   */
  @Bean
  public PostFilter postFilter() {
    return new PostFilter();
  }

}
