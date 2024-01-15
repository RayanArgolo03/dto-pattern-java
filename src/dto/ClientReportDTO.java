package dto;

import java.time.LocalTime;

public class ClientReportDTO extends EntityDTO {
    private final String name;
    private final int age;
    private final int index;

    public ClientReportDTO(Client client, int index) {
        super(client.getCreationInstant());
        this.name = client.getName();
        this.age = client.getAge();
        this.position = index + 1;
    }

    @Override
    public String toString() {
        return "[CREATED IN " + getCreationInstance().format(DateTimeFormatter.ofPattern("HH:mm")) + "]"
                + name + " - " + age + " - " + position + " in list ";
    }

}
