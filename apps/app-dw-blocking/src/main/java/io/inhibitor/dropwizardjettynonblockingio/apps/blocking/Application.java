package io.inhibitor.dropwizardjettynonblockingio.apps.blocking;

import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import java.net.URL;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class Application extends io.dropwizard.core.Application<Configuration> {

  public static void main(String[] args) throws Exception {
    URL url = Application.class.getClassLoader().getResource("config.yml");
    args = new String[]{"server", url.getPath()};

    new Application().run(args);
  }

  @Override
  public void initialize(Bootstrap<Configuration> bootstrap) {
    bootstrap.setConfigurationSourceProvider(
        new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
            new EnvironmentVariableSubstitutor(false)));

    bootstrap.addBundle(
        GuiceBundle.builder()
            .enableAutoConfig(
                "io.inhibitor.dropwizardjettynonblockingio.apps.blocking.behaviors",
                "io.inhibitor.dropwizardjettynonblockingio.apps.blocking.resources",
                "io.inhibitor.dropwizardjettynonblockingio.apps.blocking.services"
            )
            .build()
    );
  }

  @Override
  public void run(Configuration configuration, Environment environment) throws Exception {

  }
}
