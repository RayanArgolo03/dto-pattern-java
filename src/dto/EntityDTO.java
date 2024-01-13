package dto;

import java.time.LocalTime;

public class EntityDTO {
    private final LocalTime creationInstance;

    public EntityDTO(LocalTime creationInstance) {
        this.creationInstance = creationInstance;
    }

}
