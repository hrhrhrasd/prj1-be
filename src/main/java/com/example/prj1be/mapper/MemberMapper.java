package com.example.prj1be.mapper;

import com.example.prj1be.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO member (id, nickName,password, email)
        VALUES (#{id}, #{nickName}, #{password}, #{email})
        """)
    int insert(Member member);

    @Select("""
        SELECT id FROM member
        WHERE id = #{id}
        """)
    String selectId(String id);

    @Select("""
        select nickName from member
        where nickname = #{nickName}
""")
    String selectNickName(String nickName);

    @Select("""
        SELECT email FROM member
        WHERE email = #{email}
        """)
    String selectEmail(String email);

    @Select("""
        SELECT id, nickName ,password, email, inserted
        FROM member
        ORDER BY inserted DESC
        """)
    List<Member> selectAll();

    @Select("""
        SELECT *
        FROM member
        WHERE id = #{id}
        """)
    Member selectById(String id);

    @Delete("""
        delete from member
        where id = #{id}
""")
    int deleteById(String id);

    @Update("""
        <script>
        update member
        set
        nickName = #{nickName},
        <if test="password != ''">
        password = #{password},
        </if>
        email = #{email}
        where id = #{id}
        </script>
""")
    int update(Member member);
}