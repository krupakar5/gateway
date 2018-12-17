package app.net.utils;

import org.testng.annotations.Test;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * The Class AppConstantsTest.
 *
 * @author chirags
 */
public class AppConstantsTest extends AbstractTestNGSpringContextTests {

  /**
   * Test.
   */
  @Test
  public void test() {
    AppConstants.test();
    assert (true);
  }
}
