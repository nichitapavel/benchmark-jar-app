package benchmark.jar.app;

import matrix.lib.IHostInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo implements IHostInfo {
    @Override
    public String getName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Cannot get hostname");
            return "Linux";
        }
    }
}
