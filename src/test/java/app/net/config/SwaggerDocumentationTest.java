package app.net.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import app.net.GatewayServerApplication;

/**
 * The Class SwaggerDocumentationTest.
 *
 * @author Chirag Sardhara
 */
@SpringBootTest(classes = GatewayServerApplication.class)
@WebAppConfiguration
@ContextConfiguration(classes = GatewayServerApplication.class)
public class SwaggerDocumentationTest extends AbstractTestNGSpringContextTests {

  /** The swagger documentation. */
  @Autowired
  private SwaggerDocumentation swaggerDocumentation;

  static {
    System.setProperty("spring.profiles.active", "DEV");
  }

  /**
   * Gets the.
   */
  @Test
  public void get() {
    swaggerDocumentation.get();
  }

}
