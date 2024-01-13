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

    public ClientReportDTO generateReport(Client client) {
        return service.createClientDTO(client);
    }

    public void save(Client client) {
        boolean sucess = service.saveClient(client);
        if (!sucess) throw new ClientException("Client already exists!");
    }

    public Client find() {
        return service.findClient()
                .orElseThrow(() -> new ClientException("Not found!"));
    }

}
