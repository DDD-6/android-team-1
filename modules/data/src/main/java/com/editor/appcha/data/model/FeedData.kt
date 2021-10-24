package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.Feed

data class FeedData(
    val id: String,
    val title: String,
    val author: String,
    val summary: String,
    val apps: List<AppData>
) : DataModel<Feed> {

    override fun toDomain(): Feed = Feed(
        id = id,
        title = title,
        author = author,
        summary = summary,
        apps = apps.map { it.toDomain() }
    )
}
