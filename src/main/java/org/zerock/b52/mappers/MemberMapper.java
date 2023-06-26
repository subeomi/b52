package org.zerock.b52.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.b52.dto.MemberReadDTO;

public interface MemberMapper {
    
    MemberReadDTO selectOne(String email);

    @Select("select now()")
    String getTime();

    // MyBatis는 파라미터 하나밖에 받지 못 하기 때문에 @Param으로 3개를 받음
    @Insert("insert into tbl_member (email, mpw, mname) values (#{email}, #{mpw}, #{mname})")
    int insertMember(
        @Param("email") String email, 
        @Param("mpw") String mpw, 
        @Param("mname") String mname);

    @Insert("insert into tbl_member_role (email, rolename) values (#{email}, #{rolename})")
    int insertMemberRole(
        @Param("email") String email,
        @Param("rolename") String rolename
    );

}
