package com;

import com.mvc.common.controller.HelloController;
import org.springframework.test.web.servlet.MockMvc;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
        org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HelloController controller = new HelloController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("hello"));
    }
}

