package greensalt.comment.dao;

import greensalt.comment.domain.CommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    int count(Integer bno) throws Exception;
    int deleteAll(Integer bno);
    int insert(CommentDto dto) throws Exception;
    List<CommentDto> selectAll(Integer bno) throws Exception;
    CommentDto select(Integer cno) throws Exception;
    int update(CommentDto dto) throws Exception;
    int deleted(Map<String, Object> params) throws Exception;
}