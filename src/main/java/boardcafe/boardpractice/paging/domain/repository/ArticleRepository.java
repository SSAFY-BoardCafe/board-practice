package boardcafe.boardpractice.paging.domain.repository;

import boardcafe.boardpractice.paging.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a from Article a where a.id>:id order by a.id asc")
    Slice<Article> findAfterId(Long id, Pageable pageable);
}
