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
        return name + " - " + age + " - " + index + " in list";
    }

    public static final class ClientReportDTOBuilder {
        private String name;
        private int age;
        private int index;
        private LocalTime creationDate;

        private ClientReportDTOBuilder() {
        }

        public static ClientReportDTOBuilder builder() {
            return new ClientReportDTOBuilder();
        }

        public ClientReportDTOBuilder name(String name) {
            this.name = name;
            return this;
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
