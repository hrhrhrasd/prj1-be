package com.example.prj1be.mapper;

import com.example.prj1be.domain.Board;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {


    @Insert("""
        insert into board (title, content, writer)
        values (#{title}, #{content}, #{writer})
""")
    Integer insert(Board board);

    @Select("""
        select id, title, writer, inserted from board
        order by id
""")
    List<Board> getList();

    @Select("""
        select id, title, content, writer, inserted from board
        where id = #{id}
""")
    Board selectById(Integer id);

    @Delete("""
        delete from board
        where id = #{id}
""")
    int deleteById(Integer id);
}
