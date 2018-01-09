package com.mvc.common.controller;

import com.mvc.common.dao.UserDao;
import com.mvc.common.model.User;
import com.mvc.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    ServletContext context;
    @Autowired
    private MultipartResolver multipartResolver;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void setMultipartResolver(MultipartResolver multipartResolver) {
        this.multipartResolver = multipartResolver;
    }
    public MultipartResolver getMultipartResolver() {
        return multipartResolver;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAll() {
        return "redirect:/users/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(ModelMap model) {
        model.addAttribute(new User());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("image") MultipartFile image,
                                      @Valid User user,
                                      RedirectAttributes model,
                                      Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        if (!image.isEmpty()) {
            String fileName = context.getRealPath("/") + image.getOriginalFilename();
            image.transferTo(new File(fileName));
            user.setImageSrc(fileName);
        }
        userService.save(user);
        model.addAttribute("username", user.getName());
        model.addFlashAttribute(user);
        model.addFlashAttribute("image", userService.getUserImage(user));
        model.addFlashAttribute("firstEntry",true);
        return "redirect:/users/{username}";
    }

//    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//
//        // generate session if one doesn't exist
//        request.getSession();
//
//        token.setDetails(new WebAuthenticationDetails(request));
//        Authentication authenticatedUser = authenticationManager.authenticate(token);
//
//        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
//    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String showUserProfile(
            @PathVariable String name, ModelMap model) throws IOException {
        if (!model.containsAttribute("user")||
                !model.containsAttribute("image")) {
            User user = userService.findByName(name);
            if (user == null) {
                LOGGER.log(Level.WARNING, "User not found id=" + name);
                throw new EmptyResultDataAccessException("User not found", 1);
            }
            model.addAttribute("user", user);
            model.addAttribute("image", userService.getUserImage(user));
        }
        return "profile";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String resolverEmptyResult() {
        return "redirect:/users/register";
    }

    @ExceptionHandler(IOException.class)
    public String resolverIOException() {
        return "redirect:/users/register";
    }

}
