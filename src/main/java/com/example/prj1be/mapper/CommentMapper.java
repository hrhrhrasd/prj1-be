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
       SELECT
         c.id,
         c.comment,
         c.inserted,
         c.boardId,
         c.memberId,
         m.nickName memberNickName
     FROM comment c JOIN member m ON c.memberId = m.id
     WHERE boardId = #{boardId}
     ORDER BY c.id DESC
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

    @Delete("""
        delete from comment
        where boardId = #{boardId}
""")
    int deleteByBoardId(Integer boardId);

    @Delete("""
        delete from comment
        where memberId = #{memberId}
""")
    int deleteByMemberId(String memberId);
}
