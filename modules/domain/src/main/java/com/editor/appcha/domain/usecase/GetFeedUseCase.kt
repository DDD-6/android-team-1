package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.FeedDetail
import com.editor.appcha.domain.repo.FeedRepository
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(
    private val repo: FeedRepository
) : UseCase<String, FeedDetail>() {

    override suspend fun execute(param: String): Result<FeedDetail> = repo.getFeed(param)
}
