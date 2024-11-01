package boardcafe.boardpractice.todo.domain.entity;

import boardcafe.boardpractice.common.auditing.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String content;
    private boolean completed = Boolean.FALSE;
    private boolean deleted = Boolean.FALSE;

    public Todo(final String content){
        this.content = content;
    }

    public void updateCompleted(){
        this.completed = true;
    }

    public void removeTodo(){
        this.deleted = true;
    }
}
