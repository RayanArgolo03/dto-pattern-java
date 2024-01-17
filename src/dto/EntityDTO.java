package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;


@Getter
@AllArgsConstructor
public abstract class EntityDTO {
    private final LocalTime creationInstance;
}
