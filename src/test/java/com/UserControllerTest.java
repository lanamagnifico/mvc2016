package com;

import com.TestConfig;
import com.mvc.common.controller.UserController;
import com.mvc.common.model.User;
import com.mvc.common.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@WebAppConfiguration
public class UserControllerTest {
//    @Autowired
//    WebApplicationContext wac;

    MockMvc mockMvc;

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
//    }

    @Test
    public void testRegister() throws Exception {

//        User user = new User();
//        user.setName("Yahoo");
//        user.setEmail("yahoo@yahoo.com");
//        user.setPassword("pass");
//        user.setImageSrc("photo.jpg");
//        MockMultipartFile firstFile = new MockMultipartFile("image", "photo.jpg", "image/jpeg", "some photo".getBytes());
//
//        UserService userService = mock(UserService.class);
//        when(userService.save(user)).thenReturn(true);
//
//        UserController userController = new UserController();
//        userController.setUserService(userService);
//        userController.setMultipartResolver(new StandardServletMultipartResolver());
//
//        ResultActions mvcResult = mockMvc.perform(fileUpload("/users/register").file(firstFile));
//        mvcResult.andDo(print());
        //.andExpect(status().isOk());
    }

    @Test
    public void testProfile() throws Exception {
//        User user = new User();
//        user.setName("Yahoo");
//        user.setEmail("yahoo@yahoo.com");
//        user.setPassword("pass");
//        UserService userService = mock(UserService.class);
//        when(userService.findByName("Yahoo")).thenReturn(user);
//
//        UserController userController = new UserController();
//        userController.setUserService(userService);
//        userController.setMultipartResolver(new StandardServletMultipartResolver());
//
//        MockMvc mockMvc0 = standaloneSetup(userController).build();
//        mockMvc0.perform(get("/users/{username}","Yahoo"))
//                .andDo(print());

//                .andExpect(status().isOk())
//                .andExpect(view().name("profile"))
//                .andExpect(model().attributeExists("user"))
//                .andExpect(model().attribute("user",user));
    }
}