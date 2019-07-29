package benchmark.jar.app;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.Map;


public class Parser {

    public static final Map parse(String[] args) {
        ArgumentParser parser =
                ArgumentParsers.newFor("benchmark-android-appium").build()
                .defaultHelp(true)
                .description(
                        "Set benchmark, number of threads and problem size. " +
                        "Set appium device to use."
                );
        parser.addArgument("-b", "--benchmark")
                .help("Specify NAS benchmark to run")
                .type(String.class)
                .required(true);
        parser.addArgument("-s", "--size")
                .help("Specify the problem size")
                .type(String.class)
                .required(true);
        parser.addArgument("-t", "--threads")
                .help("Threads to use")
                .type(int.class)
                .required(true);
        parser.addArgument("-e", "--http-endpoint").
                help("HTTP endpoint to mark when fill and multiplication operations start and finish")
                .type(String.class);

        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }

        return ns.getAttrs();
    }
}
