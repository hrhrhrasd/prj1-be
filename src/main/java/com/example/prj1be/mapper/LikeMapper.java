package com.example.prj1be.mapper;

import com.example.prj1be.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("""
        select count(*) from boardLike
        where boardId = #{boardId}
        and memberId = #{memberId}
""")
    int selectByBoardMemberId(Integer boardId, String memberId);

    @Select("""
        select count(*) from boardLike
        where boardId = #{id}
""")
    Integer selectByBoardId(Integer id);
}
