package boardcafe.boardpractice.paging.presentation.response;

import boardcafe.boardpractice.paging.application.response.ArticleItem;

import java.util.List;

public record getCursorArticlesResponse(Long lastId, List<ArticleItem> articles) {
}
