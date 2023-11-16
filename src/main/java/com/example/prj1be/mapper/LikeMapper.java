package com.example.prj1be.mapper;

import com.example.prj1be.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    @Delete("""
        delete from boardLike
        where boardId = #{boardId}
        and memberId = #{memberId}
""")
    int delete(Like like);

    @Insert("""
        insert into boardLike(boardId, memberId)
        values (#{boardId}, #{memberId})
""")
    int insert(Like like);
}
