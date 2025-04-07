import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Optional<Todo> findById(long id);
}