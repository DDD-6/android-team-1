package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.repo.FeedRepository
import com.editor.appcha.domain.usecase.UpdateFavoriteUseCase.Params
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(
    private val repo: FeedRepository
) : UseCase<Params, Unit>() {

    data class Params(
        val feedId: String,
        val isFavorite: Boolean
    )

    override suspend fun execute(param: Params): Result<Unit> =
        repo.updateFavorite(param.feedId, param.isFavorite)
}
