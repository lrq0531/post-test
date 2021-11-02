import React from "react"
import {
    useState,
    useEffect,
    memo,
} from 'react'

import PostCard from './PostCard'
import {
    getUrlJson,
} from 'main/utils/httpUtils'
import {
    URL_POSTS,
    URL_POSTS_AND_COMMENTS,

} from 'main/constants'

const styles = {
    root: {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'flex-start',
    },

    table: {
        width: '100%',
        border: '2px solid grey',
    },

    button: {
        width: '300px',
        marginBottom: '8px',
    },


}

const initState = {
    posts: [{
        userId: 0,
        id: 1,
        title: "title of post",
        body: "post content",
        commentList: null,
    }, ],
}

const Posts = props => {

    const [init, setInit] = useState(false)
    const [posts, setPosts] = useState(initState.posts)
    const [fetchedAll, setFetchAll] = useState(false)

    useEffect(() => {
        if (!init) {
            getUrlJson(URL_POSTS).then(json => setPosts(json.postList))
            setInit(true)
        }
        else {
            console.log("loaded, will not load until refresh")
        }
    })

    const onClickFetchAllComments = event => {
        event.preventDefault()
        if (!fetchedAll) {
            getUrlJson(URL_POSTS_AND_COMMENTS).then(json => setPosts(json.postList))
        }
        else {
            getUrlJson(URL_POSTS).then(json => setPosts(json.postList))
        }

        setFetchAll(!fetchedAll)
    }


    return (
        <div style={styles.root}>
            <button onClick={onClickFetchAllComments} style={styles.button}>Fetch All Cooments</button>
            <div>{posts.map(post => <PostCard post={post} comments={post.commentList}/>)}
            </div>
        </div>
    )
}

export default memo(Posts)