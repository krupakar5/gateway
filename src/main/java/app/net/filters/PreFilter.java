/**
 * package declaration
 */
package app.net.filters;

/**
 * import statements
 */
import com.netflix.zuul.ZuulFilter;

/**
 * The Class PreFilter.
 *
 * @author chirags
 */
public class PreFilter extends ZuulFilter {

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.ZuulFilter#filterType()
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.ZuulFilter#filterOrder()
   */
  @Override
  public int filterOrder() {
    return 1;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.IZuulFilter#shouldFilter()
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.IZuulFilter#run()
   */
  @Override
  public Object run() {
    return null;
  }

}
