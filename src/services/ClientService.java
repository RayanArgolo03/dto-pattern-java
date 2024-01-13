package services;

import domain.Client;
import dto.ClientReportDTO;
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

        String name = ReadService.readString("Enter the client name: ");
        if (!validString(name)) throw new ClientException("Invalid name!");

        int age = ReadService.readInt("Enter the client age : ");
        if (!validAge(age)) throw new ClientException("Invalid age!");

        String city = ReadService.readString("Enter the client city: ");
        if (!validString(city)) throw new ClientException("Invalid city!");

        return Client.ClientBuilder.builder()
                .name(name)
                .age(age)
                .city(city)
                .creationInstant(LocalTime.now())
                .build();
    }

    public ClientReportDTO createClientDTO(Client client) {
        return ClientReportDTO.ClientReportDTOBuilder.builder()
                .name(client.getName())
                .age(client.getAge())
                .creationDate(client.getCreationInstant())
                .index(clientRepository.findIndex(client))
                .build();
    }


    public boolean saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClient() {

        FilteringOption filteringOption = ReadService.readOption(FilteringOption.class);

        return switch (filteringOption) {
            case BY_NAME -> {
                String name = ReadService.readString("Enter the client name: ");
                yield clientRepository.findByName(name);
            }

            case LAST_ADDED -> clientRepository.findLastAdedd();
        };
    }

    private static boolean validString(String str) {
        return str.length() > 2;
    }

    private static boolean validAge(int age) {
        return age > 18 && age < 91;
    }


}
