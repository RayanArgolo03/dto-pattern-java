package repository.interfaces;

import java.util.Optional;
import java.util.function.Predicate;

public interface IEntityRepository<T> {
    Optional<T> findBy (Predicate<T> predicate);

}
