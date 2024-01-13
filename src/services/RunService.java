package services;

import controllers.ClientController;
import domain.Client;
import dto.EntityDTO;
import enums.Option;

import java.util.InputMismatchException;

public final class RunService {
    public static void runApplication() {

        ClientController clientController = new ClientController();

        Option option = null;
        do {

            try {
                option = ReadService.readOption(Option.class);

                switch (option) {
                    case CREATE -> {
                        Client a = clientController.create();
                        clientController.save(a);
                    }

                    case PRINT -> {
                        Client client = clientController.find();
                        EntityDTO entityDTO = clientController.generateReport(client);
                        System.out.println("\n" + entityDTO);
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!");
                break;
            } catch (RuntimeException e) {
                System.out.println("Error! " + e.getMessage());
            }

        } while (option != Option.EXIT);
    }

}
