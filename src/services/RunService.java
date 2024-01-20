package services;

import controllers.ClientController;
import domain.Client;
import dto.EntityDTO;
import enums.Option;
import lombok.extern.log4j.Log4j2;

import java.util.InputMismatchException;

@Log4j2
public final class RunService {
    public static void runApplication() {

        ClientController clientController = new ClientController();

        outer:
        do {

            try {
                Option option = ReadService.readEnum(Option.class);

                switch (option) {

                    case CREATE -> {
                        Client client = clientController.create();
                        clientController.save(client);
                    }

                    case PRINT -> {
                        Client client = clientController.find();
                        EntityDTO entityDTO = clientController.generateReport(client);
                        System.out.println("\n" + entityDTO);
                    }

                    case EXIT -> {
                        break outer;
                    }

                    //Adding defensive programming
                    default -> throw new IllegalArgumentException("This option is deprecated!");

                }

                //Adding Logging
            } catch (InputMismatchException e) {
                log.info("Entry with invalid data type: " + e.getMessage());
                break;
            } catch (RuntimeException e) {
                log.error(e.getMessage());
            }

        } while (true);
    }

}
