package repository.classes;

import domain.Client;
import lombok.extern.log4j.Log4j2;
import repository.interfaces.IClientRepository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Log4j2
public class ClientRepository implements IClientRepository {

    private final Set<Client> clients;

    public ClientRepository() {
        this.clients = new LinkedHashSet<>();
    }

    @Override
    public boolean save(Client client) {
        return clients.add(client);
    }

    @Override
    public Optional<Client> findLastAdedd() {
        //Adding LOG4J2
        if (clients.isEmpty()) log.info("Database is empty!");
        return clients.stream().reduce((c1, c2) -> c2);
    }

    @Override
    public Optional<Client> findBy(Predicate<Client> predicate) {
        return clients.stream()
                .filter(predicate)
                .findFirst();
    }

    public Optional<Client> findByName(String name) {

        //Adding LOG4J2 message
        log.info("Client is being searched in database with a name {}..", name);

        //Adding defensive programming
        return findBy(client -> name.equalsIgnoreCase(client.getName()));
    }

    public int findIndex(Client client) {
        return clients.stream().toList().indexOf(client);
    }
}
