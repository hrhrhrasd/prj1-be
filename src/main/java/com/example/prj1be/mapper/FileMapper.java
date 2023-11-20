package com.example.prj1be.mapper;

import com.example.prj1be.domain.BoardFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("""
        insert into boardFile (boardId, name)
        values (#{boardId}, #{name})
""")
    int insert(Integer boardId, String name);

    @Select("""
        select id, name from boardFile
        where boardId = #{boardId}
""")
    List<BoardFile> selectNamesByBoardId(Integer boardId);
}
