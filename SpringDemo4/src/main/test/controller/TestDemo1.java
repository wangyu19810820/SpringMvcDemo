package controller;

import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by admin on 2017/5/17.
 */

public class TestDemo1 {
    @Test
    public void testIndex() throws Exception {
        Demo1 demo1 = new Demo1();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(demo1).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/Demo1"))
                .andExpect(MockMvcResultMatchers.view().name("/demo1/index"));
    }
}
