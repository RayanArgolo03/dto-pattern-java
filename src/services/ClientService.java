package services;

import domain.Client;
import dto.ClientReportDTO;
import dto.EntityDTO;
import enums.FilteringOption;
import exceptions.ClientException;
import repository.classes.ClientRepository;

import java.time.LocalTime;
import java.util.Optional;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public Client createClient() {

        String name = ReadService.readString("Enter the client name");
        if (!validString(name)) throw new ClientException("Invalid name!");

        int age = ReadService.readInt("Enter the client age");
        if (!validAge(age)) throw new ClientException("Invalid age!");

        String city = ReadService.readString("Enter the client city");
        if (!validString(city)) throw new ClientException("Invalid city!");

        return Client.ClientBuilder.builder()
                .name(name)
                .age(age)
                .city(city)
                .creationInstant(LocalTime.now())
                .build();
    }


    public boolean saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClient() {

        FilteringOption filteringOption = ReadService.readEnum(FilteringOption.class);

        //Adding defensive programming
        if (filteringOption == null) throw new ClientException("Filtering option cannot be null!");

        return switch (filteringOption) {
            case BY_NAME -> {
                String name = ReadService.readString("Enter the client name: ");

                //Adding defensive programming
                if (name == null) throw new ClientException("Name cannot be null!");
                yield clientRepository.findByName(name);
            }

            case LAST_ADDED -> clientRepository.findLastAdedd();

            //Adding defensive programming
            default -> throw new IllegalArgumentException("This option is deprecated!");
        };
    }

    public EntityDTO createClientDTO(Client client) {
        return new ClientReportDTO(client, clientRepository.findIndex(client));
    }

    private static boolean validString(String str) {
        return str.length() > 2;
    }

    private static boolean validAge(int age) {
        return age > 18 && age < 91;
    }


}
