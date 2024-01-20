package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

@AllArgsConstructor
@Builder
@Getter
public class Client {

    private final LocalDate birthDate = LocalDate.of(2003, Month.AUGUST, 10);
    private final String name;
    private final int age = Period.between(birthDate, LocalDate.now()).getMonths();
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

