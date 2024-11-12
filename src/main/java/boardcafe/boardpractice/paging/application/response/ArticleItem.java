package boardcafe.boardpractice.paging.application.response;

import boardcafe.boardpractice.paging.domain.Article;

import java.time.LocalDateTime;


public record ArticleItem(Long id, String title, LocalDateTime createdAt){
    public static ArticleItem of(Article article) {
        return new ArticleItem(article.getId(), article.getTitle(), article.getCreatedAt());
    }
}
