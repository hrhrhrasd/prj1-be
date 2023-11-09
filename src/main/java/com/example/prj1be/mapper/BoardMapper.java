package com.example.prj1be.mapper;

import com.example.prj1be.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {


    @Insert("""
        insert into board (title, content, writer)
        values (#{title}, #{content}, #{writer})
""")
    Integer insert(Board board);
}
