package boardcafe.boardpractice.paging.presentation.request;

import boardcafe.boardpractice.paging.application.response.ArticleItem;

import java.util.List;

public record createArticlesRequest(List<ArticleItem> articles) {
}
