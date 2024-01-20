package controllers;

import domain.Client;
import dto.EntityDTO;
import exceptions.ClientException;
import lombok.extern.log4j.Log4j2;
import services.ClientService;

@Log4j2
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
        return service.findClient().orElseThrow(() ->  new ClientException("Not found!"));
    }

    public EntityDTO generateReport(Client client) {
        return service.createClientDTO(client);
    }

}
