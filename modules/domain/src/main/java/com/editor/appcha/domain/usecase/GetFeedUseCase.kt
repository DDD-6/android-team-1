package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.repo.FeedRepository
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(
    private val repo: FeedRepository
) : UseCase<String, Feed>() {

    override suspend fun execute(param: String): Result<Feed> = repo.getFeed(param)
}
