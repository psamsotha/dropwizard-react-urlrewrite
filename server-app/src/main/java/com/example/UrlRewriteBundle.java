package com.example;


import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterRegistration;

public class UrlRewriteBundle implements ConfiguredBundle<ExampleConfiguration> {

    private static final String DEFAULT_CONF_PATH = "urlrewrite.xml";

    private final String rewriteConfPath;


    public UrlRewriteBundle() {
        this(null);
    }

    public UrlRewriteBundle(String rewriteConfPath) {
        this.rewriteConfPath = rewriteConfPath;
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws Exception {
        FilterRegistration.Dynamic registration = environment.servlets()
                .addFilter("UrlRewriteFilter", new UrlRewriteFilter());
        registration.addMappingForUrlPatterns(null, true, "/*");
        registration.setInitParameter("confPath", getConfPath(configuration));
    }

    /**
     * The UrlRewriteFilter will will look for a file on the classpath.
     * We will use the following to resolve the path:
     *
     * 1. From the configuration.
     * 2. If not in the configuration, passed to the constructor.
     * 3. If not in the constructor, use the default.
     */
    private String getConfPath(ExampleConfiguration configuration) {
        return configuration.getRewriteConfPath() != null
                ? configuration.getRewriteConfPath()
                : this.rewriteConfPath != null
                        ? this.rewriteConfPath
                        : DEFAULT_CONF_PATH;
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) { /* nothing */ }
}
