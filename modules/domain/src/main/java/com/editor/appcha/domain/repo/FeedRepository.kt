package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Feed

interface FeedRepository {

    suspend fun getFeeds(): Result<List<Feed>>
}
