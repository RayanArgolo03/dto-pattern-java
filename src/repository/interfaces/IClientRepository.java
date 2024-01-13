package repository.interfaces;

import domain.Client;

import java.util.Optional;

public interface IClientRepository extends IEntityRepository<Client> {

    boolean save(Client client);

    //Tenta buscar o último adicionado, se não existir, nullable
    Optional<Client> findLastAdedd();
}
