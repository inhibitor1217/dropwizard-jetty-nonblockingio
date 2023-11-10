package io.inhibitor.dropwizardjettynonblockingio.apps.blocking;

import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class Application extends io.dropwizard.core.Application<Configuration> {

  public static void main(String[] args) throws Exception {
    new Application().run(args);
  }

  @Override
  public void initialize(Bootstrap<Configuration> bootstrap) {

  }

  @Override
  public void run(Configuration configuration, Environment environment) throws Exception {

  }
}
