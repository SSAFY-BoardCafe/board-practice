package boardcafe.boardpractice.paging.domain;

import boardcafe.boardpractice.common.auditing.BaseEntity;
import boardcafe.boardpractice.paging.application.response.ArticleItem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;

    public Article(String title) {
        this.title = title;
    }

    public static Article of(ArticleItem articleItem) {
        return new Article(articleItem.title());
    }
}
