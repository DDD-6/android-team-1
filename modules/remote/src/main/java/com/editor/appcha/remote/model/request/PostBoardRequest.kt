package com.editor.appcha.remote.model.request

import com.editor.appcha.data.model.request.PostBoardData

data class PostBoardRequest(
    val title: String,
    val body: String
) {

    companion object {

        operator fun invoke(data: PostBoardData) = PostBoardRequest(
            title = data.title,
            body = data.body
        )
    }
}
