package app.net.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.net.GatewayServerApplication;
import app.net.utils.AppConstants;

/**
 * The Class HomeControllerTest.
 *
 * @author Chirag Sardhara
 */
@SpringBootTest(classes = GatewayServerApplication.class)
@WebAppConfiguration
@ContextConfiguration(classes = GatewayServerApplication.class)
public class HomeControllerTest extends AbstractTestNGSpringContextTests {

  /**
   * . mockMvc
   */
  private MockMvc mockMvc;

  /**
   * . wac
   */
  @Autowired
  private WebApplicationContext wac;

  static {
    System.setProperty("spring.profiles.active", "DEV");
  }

  /**
   * Inits the.
   *
   * @throws Exception
   *           the exception
   */
  @BeforeMethod
  public void init() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  /**
   * Health.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void health() throws Exception {
    ResultActions resultActions = mockMvc.perform(get(AppConstants.HEALTH_CHECK_ENDPOINT));
    resultActions.andExpect(status().isOk());
    resultActions.andDo(print());
  }
}
