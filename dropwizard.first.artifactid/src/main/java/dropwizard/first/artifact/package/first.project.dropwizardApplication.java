package dropwizard.first.artifact.package;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class first.project.dropwizardApplication extends Application<first.project.dropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new first.project.dropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "first.project.dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<first.project.dropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final first.project.dropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
