package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.repo.FeedRepository
import javax.inject.Inject

class GetFeedListUseCase @Inject constructor(
    private val repo: FeedRepository
) : UseCase<Unit, List<Feed>>() {

    override suspend fun execute(param: Unit): Result<List<Feed>> = repo.getFeeds()
}
