package domain;

import lombok.*;

import java.time.LocalTime;
import java.util.Objects;

@AllArgsConstructor
@Builder
@Getter
public class Client {
    private final String name;
    private final int age;
    private final String city;
    private final LocalTime creationInstant;


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
}

