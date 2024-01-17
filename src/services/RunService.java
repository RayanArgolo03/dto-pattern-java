package services;

import controllers.ClientController;
import domain.Client;
import dto.EntityDTO;
import enums.Option;

import java.util.InputMismatchException;

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
                        System.out.println(client);
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

            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!");
                break;
            } catch (RuntimeException e) {
                System.out.println("Error! " + e.getMessage());
            }

        } while (true);
    }

}
