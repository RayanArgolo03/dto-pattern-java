package dto;

import java.time.LocalTime;

public class ClientReportDTO extends EntityDTO {
    private final String name;
    private final int age;
    private final int index;

    public ClientReportDTO(LocalTime creationDate, String name, int age, int index) {
        super(creationDate);
        this.name = name;
        this.age = age;
        this.index = index;
    }

    @Override
    public String toString() {
        return "[CREATED IN " + getCreationInstance().format(DateTimeFormatter.ofPattern("HH:mm")) + "]"
                + name + " - " + age + " - " + position + " in list ";
    }

        public ClientReportDTOBuilder age(int age) {
            this.age = age;
            return this;
        }

        public ClientReportDTOBuilder index(int index) {
            this.index = index;
            return this;
        }

        public ClientReportDTOBuilder creationDate(LocalTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public ClientReportDTO build() {
            return new ClientReportDTO(creationDate, name, age, index);
        }
    }
}
