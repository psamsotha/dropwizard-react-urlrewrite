package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ExampleConfiguration extends Configuration {

    private String rewriteConfPath;


    @JsonProperty
    public String getRewriteConfPath() {
        return this.rewriteConfPath;
    }

    public void setRewriteConfPath(String rewriteConfPath) {
        this.rewriteConfPath = rewriteConfPath;
    }
}
