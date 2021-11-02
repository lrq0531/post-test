import { memo } from 'react'


const styles = {
    
    dataCell: {
        border: '1px solid grey',
        textAlign: 'left',
        color: 'blue',
    },

}

const CommentLine = props => {

    const {
        comment,
    } = props
    
    return (
        <tr>
            <td style={styles.dataCell}>{comment.body.trim()}</td>
        </tr>
    )
}

export default memo(CommentLine)
