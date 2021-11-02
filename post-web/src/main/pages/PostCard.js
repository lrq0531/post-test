import {
    memo,
    useEffect,
    useState,
} from 'react'

import { getUrlJson } from 'main/utils/httpUtils'
import { URL_COMMENTS_FOR_POST } from 'main/constants'
import CommentLine from './CommentLine'

const styles = {
    root: {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'flex-start',
        marginBottom: '12px',
    },

    table: {
        width: '100%',
        border: '1px solid grey',
    },

    cell: {
        border: '1px solid grey',
        width: '64px',

    },

    dataCell: {
        border: '1px solid grey',
        textAlign: 'left',        
    },

}

const PostCard = props => {

    const {
        post,
        comments,
    } = props

    const [postComments, setPostComments] = useState(comments)
    const [fetched, setFetched] = useState(false)

    const onClickShowComments = event => {
        event.preventDefault()

        if (!fetched) {
            getUrlJson(URL_COMMENTS_FOR_POST + post.id).then(json => {
                setPostComments(json.commentList)
                setFetched(!fetched)
            })
        }
        else {
            setFetched(false)
            setPostComments(null)
        }
    }

    useEffect(() => {
        setPostComments(comments)
    }, [comments,])

    return (

        <div style={styles.root}>
            <button onClick={onClickShowComments}>Comments</button>
            <div>
                <table style={styles.table}>
                    <tr >
                        <th style={styles.cell}>Title</th>
                        <td style={styles.dataCell}>{post.title.trim()}</td>
                    </tr>

                    <tr>
                        <th style={styles.cell}>Post</th>
                        <td style={styles.dataCell}>{post.body.trim()}</td>
                    </tr>
                </table>
            </div>

            <div>
                <table style={styles.table}>
                    {postComments && postComments.map(comment => <CommentLine comment={comment} />)}
                </table>
            </div>
        </div>
    )
}

export default memo(PostCard)
