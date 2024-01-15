package domain;

import java.time.LocalTime;
import java.util.Objects;

public class Client {

    private final String name;
    private final int age;
    private final String city;
    private final LocalTime creationInstant;

    private Client(String name, int age, String city, LocalTime creationInstant) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.creationInstant = creationInstant;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalTime getCreationInstant() {
        return creationInstant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static final class ClientBuilder {
        private String name;
        private int age;
        private String city;
        private LocalTime creationInstant;

        private ClientBuilder() {
        }

        public static ClientBuilder builder() {
            return new ClientBuilder();
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder age(int age) {
            this.age = age;
            return this;
        }

        public ClientBuilder city(String city) {
            this.city = city;
            return this;
        }

        public ClientBuilder creationInstant(LocalTime creationInstant) {
            this.creationInstant = creationInstant;
            return this;
        }

        public Client build() {
            return new Client(name, age, city, creationInstant);
        }
    }
}
