package controllers;

import domain.Client;
import dto.ClientReportDTO;
import exceptions.ClientException;
import services.ClientService;

public class ClientController {
    private final ClientService service;

    public ClientController() {
        this.service = new ClientService();
    }

    public Client create() {
        return service.createClient();
    }

    //Adding defensive programming
    public void save(Client client) {

        if (client == null) {
            throw new ClientException("Client cannot be null!");
        }

        boolean sucess = service.saveClient(client);
        if (!sucess) throw new ClientException("Client already exists!");
    }

    public Client find() {
        return service.findClient()
                .orElseThrow(() -> new ClientException("Not found!"));
    }

}
