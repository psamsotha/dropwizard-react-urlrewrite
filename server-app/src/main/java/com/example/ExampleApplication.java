package com.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<ExampleConfiguration> {


    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "react-urlrewrite-example";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(new UrlRewriteBundle());
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "assets/index.html"));
    }

    @Override
    public void run(ExampleConfiguration configuration,
                    Environment environment) {

        environment.jersey().register(ExampleResource.class);
        environment.jersey().setUrlPattern("/api/*");
    }
}
