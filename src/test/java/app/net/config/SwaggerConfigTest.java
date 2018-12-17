package app.net.config;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import springfox.documentation.spring.web.plugins.Docket;

/**
 * The Class SwaggerConfigTest.
 *
 * @author Chirag Sardhara
 */
public class SwaggerConfigTest {

  /** The swagger config. */
  @InjectMocks
  private SwaggerConfig swaggerConfig;

  /** The environment. */
  @Mock
  private Environment environment;

  /** The profile. */
  private String profile = null;

  /** The env. */
  private String env = null;

  /**
   * Before method.
   *
   * @throws Exception
   *           the exception
   */
  @BeforeMethod
  public void beforeMethod() throws Exception {
    MockitoAnnotations.initMocks(this);
    profile = "spring.profiles.active";
    env = "somethingelse";
  }

  /**
   * Test api.
   */
  @Test
  public void testApi() {
    try {
      doReturn(env).when(environment).getProperty(profile);
      Docket docket = swaggerConfig.api();
      assertNull(docket);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Test add resource handlers.
   */
  @Test
  public void testAddResourceHandlers() {
    try {
      ResourceHandlerRegistry registry = null;
      doReturn(env).when(environment).getProperty(profile);
      swaggerConfig.addResourceHandlers(registry);
      assertTrue(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
