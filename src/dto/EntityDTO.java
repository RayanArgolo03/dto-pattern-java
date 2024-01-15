package dto;

import java.time.LocalTime;

public abstract class EntityDTO {
    private final LocalTime creationInstance;

    public EntityDTO(LocalTime creationInstance) {
        this.creationInstance = creationInstance;
    }

    public LocalTime getCreationInstance() {
        return creationInstance;
    }
}
