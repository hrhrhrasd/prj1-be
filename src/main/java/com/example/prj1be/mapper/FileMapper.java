package com.example.prj1be.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    @Insert("""
        insert into boardFile (boardId, name)
        values (#{boardId}, #{name})
""")
    int insert(Integer boardId, String name);
}
