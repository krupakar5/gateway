package app.net.filters;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.assertNotNull;

/**
 * The Class PreFilterTest.
 *
 * @author chirags
 */
@SpringBootTest
public class PreFilterTest extends AbstractTestNGSpringContextTests {

  /** The pre filter. */
  @Autowired
  private PreFilter preFilter;

  /**
   * Run.
   */
  @Test
  public void run() {
    Object object = preFilter.run();
    AssertJUnit.assertNull(object);
  }

  /**
   * Should filter.
   */
  @Test
  public void shouldFilter() {
    boolean bool = preFilter.shouldFilter();
    assertNotNull(bool);
  }

  /**
   * Filter type.
   */
  @Test
  public void filterType() {
    String str = preFilter.filterType();
    assertNotNull(str);
  }

  /**
   * Filter order.
   */
  @Test
  public void filterOrder() {
    int order = preFilter.filterOrder();
    assertNotNull(order);
  }
}
