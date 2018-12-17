package app.net;

import org.testng.annotations.Test;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import app.net.utils.AppConstants;

/**
 * The Class GatewayServerApplicationTest.
 *
 * @author chirags
 */
public class GatewayServerApplicationTest extends AbstractTestNGSpringContextTests {

  static {
    System.setProperty(AppConstants.SPRING_ACTIVE_PROFILE_PROPERTY_NAME, "DEV");
  }

  /**
   * Main.
   */
  @Test
  public void main() {
    String[] args = {"DEV"};
    GatewayServerApplication.main(args);
    assert (true);
  }
}
