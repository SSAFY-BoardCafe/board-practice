package boardcafe.boardpractice.todo.domain;

import boardcafe.boardpractice.todo.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


/* extends JpaRepository<테이블명, id 자료형>
   JpaRepository 상속 -> Bean으로 알아서 등록해주므로 어노테이션 필요 없음
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

    //삭제되지 않은 투두리스트 목록
    List<Todo> findByDeletedFalse();

    //삭제되지않은 특정 id의 투두
    Optional<Todo> findByIdAndDeletedFalse(Long id);
}
