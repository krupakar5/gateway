/**
 * package declaration
 */
package app.net.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * SwaggerDocumentation Class.
 */
@Component
@Primary
@EnableAutoConfiguration
public class SwaggerDocumentation implements SwaggerResourcesProvider {

  /** The environment. */
  @Autowired
  private Environment environment;

  /** The discovery client. */
  @Autowired
  private DiscoveryClient discoveryClient;
  /** The spring profile val for active profile based on env. */
  private static final String SPRING_PROFILE_VALUE = "spring.profiles.active";

  /** The Constant PROFILE_VALUE. */
  private static final List<String> PROFILE_VALUE = Arrays.asList("DEV", "TEST");

  /*
   * (non-Javadoc)
   *
   * @see com.google.common.base.Supplier#get()
   */
  @Override
  public List<SwaggerResource> get() {
    List<String> services = null;
    List<SwaggerResource> resources = new ArrayList<>();
    if (PROFILE_VALUE.stream().anyMatch(x -> x.equalsIgnoreCase(
        environment.getRequiredProperty(SPRING_PROFILE_VALUE)))) {
      services = discoveryClient.getServices();
      for (String service : services) {
        resources.add(swaggerResource(service, "/" + service + "/v2/api-docs", "2.0"));
      }
      return resources;
    } else {
      return resources;
    }
  }

  /**
   * swaggerResource method.
   *
   * @param name
   *          String
   * @param location
   *          String
   * @param version
   *          String
   * @return SwaggerResource
   */
  private SwaggerResource swaggerResource(final String name, final String location,
      final String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }

}
