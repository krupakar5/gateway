package app.net.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.net.utils.AppConstants;

/**
 * The Class HomeController.
 *
 * @author Chirag Sardhara
 */
@RestController
public class HomeController {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LogManager.getLogger("logger");

  /**
   * Health.
   *
   * @return the string
   */
  @RequestMapping(value = AppConstants.HEALTH_CHECK_ENDPOINT, method = RequestMethod.GET)
  public String health() {
    LOGGER.info(AppConstants.HEALTH_CHECK_ENDPOINT + " end point called");
    return AppConstants.ALIVE_MSG;
  }

}
