package com.oracle.itcdropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.oracle.itcdropwizard.resources.CoinResource;

public class CoinApplication extends Application<CoinConfiguration> {

    public static void main(String[] args) throws Exception {
        new CoinApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoinConfiguration> bootstrap) {
        // Initialization
    }

    @Override
    public void run(CoinConfiguration configuration, Environment environment) {
        final CoinResource resource = new CoinResource();
        environment.jersey().register(resource);
    }
}
