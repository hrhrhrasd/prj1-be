package com.example.prj1be.mapper;

import com.example.prj1be.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("""
       insert into comment (boardId, comment, memberId)
       values (#{boardId}, #{comment}, #{memberId})
""")
    int insert(Comment comment);

    @Select("""
       select c.id, c.boardId, c.memberId, c.comment, m.nickName, c.inserted from comment c
       join member m on c.memberId = m.id
       where boardId = #{boardId}
""")
    List<Comment> selectByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM comment
        WHERE id = #{id}
        """)
    int deleteById(Integer id);

    @Select("""
        SELECT * FROM comment
        WHERE id = #{id}
        """)
    Comment selectById(Integer id);

    @Update("""
        update comment
        set comment = #{comment}
        where id = #{id}
""")
    int update(Comment comment);
}
