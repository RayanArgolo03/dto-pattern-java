package repository.classes;

import domain.Client;
import repository.interfaces.IClientRepository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

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
        return clients.stream().reduce((c1, c2) -> c2);
    }

    @Override
    public Optional<Client> findBy(Predicate<Client> predicate) {
        return clients.stream()
                .filter(predicate)
                .findFirst();
    }

    public Optional<Client> findByName(String name) {
        return findBy(client -> client.getName().equalsIgnoreCase(name));
    }

    public int findIndex(Client client) {
        return clients.stream().toList().indexOf(client) + 1;
    }
}
