/**
 * package declaration
 */
package app.net.filters;

/**
 * import statements
 */

import app.net.utils.AppConstants;
import com.netflix.zuul.ZuulFilter;

/**
 * The Class PostFilter.
 *
 * @author chirags
 */
public class PostFilter extends ZuulFilter {

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.ZuulFilter#filterType()
   */
  @Override
  public String filterType() {
    return "post";
  }

  /*
   * (non-Javadoc)
   *
   * @see com.netflix.zuul.ZuulFilter#filterOrder()
   */
  @Override
  public int filterOrder() {
    return AppConstants.FILTER_ORDER;
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
