package com.mvc.common.config;

import com.mvc.common.controller.JdbcDriverUnregisteringListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.
        AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new JdbcDriverUnregisteringListener());

        servletContext.setInitParameter("spring.profiles.active", "mysql");
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setMultipartConfig(
                new MultipartConfigElement(servletContext.getRealPath("/tmp/uploads")));
        servlet.setLoadOnStartup(1);
        servlet.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forceEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null,true,"/*");
    }
}

