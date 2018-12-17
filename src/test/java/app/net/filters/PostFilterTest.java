package app.net.filters;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * The Class PostFilterTest.
 *
 * @author chirags
 */
@SpringBootTest
public class PostFilterTest extends AbstractTestNGSpringContextTests {

  /** The post filter. */
  @Autowired
  private PostFilter postFilter;

  /**
   * Filter type.
   */
  public void filterType() {
    String post = postFilter.filterType();
    assertNotNull(post);
  }

  /**
   * Filter order.
   */
  public void filterOrder() {
    int order = postFilter.filterOrder();
    assertNotNull(order);
  }

  /**
   * Should filter.
   */
  @Test
  public void shouldFilter() {
    boolean bool = postFilter.shouldFilter();
    assertNotNull(bool);
  }

  /**
   * Run.
   */
  @Test
  public void run() {
    Object object = postFilter.run();
    AssertJUnit.assertNull(object);
  }
}
