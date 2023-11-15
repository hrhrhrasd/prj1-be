package com.example.prj1be.mapper;

import com.example.prj1be.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    @Insert("""
       insert into comment (boardId, comment, memberId)
       values (#{boardId}, #{comment}, #{memberId})
""")
    int insert(Comment comment);
}
