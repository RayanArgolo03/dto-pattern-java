
package app;

import lombok.extern.log4j.Log4j2;
import services.RunService;


@Log4j2
public class App {
    public static void main(String[] args) {
        RunService.runApplication();
    }
}

