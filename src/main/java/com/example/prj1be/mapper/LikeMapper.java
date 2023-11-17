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
        select count(id) from boardLike
        where boardId = #{boardId}
""")
    int countByBoardId(Integer boardId);

    @Select("""
        select * from boardLike
        where boardId = #{boardId}
        and memberId = #{memberId}
""")
    Like selectByBoardIdAndMemberId(Integer boardId, String memberId);

    @Delete("""
        delete from boardLike
        where boardId = #{boardId}
""")
    int deleteByBoardId(Integer boardId);


    @Delete("""
        delete from boardLike
        where memberId = #{memberId}
""")
    int deleteByMemberId(String memberId);
}
