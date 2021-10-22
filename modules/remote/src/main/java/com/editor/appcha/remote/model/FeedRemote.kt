package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.FeedData

data class FeedRemote(
    val id: String,
    val title: String,
    val author: String,
    val summary: String,
    val apps: List<AppRemote>
) : RemoteModel<FeedData> {

    override fun toData(): FeedData = FeedData(
        id = id,
        title = title,
        author = author,
        summary = summary,
        apps = apps.map { it.toData() }
    )
}
