package greensalt.comment.service;

import greensalt.comment.domain.CommentDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    int getCount(Integer bno) throws Exception;

    @Transactional(rollbackFor = Exception.class)
//    int remove(Integer cno, Integer bno, Integer c_id) throws Exception;
    int remove(@Param("cno") Integer cno, Integer bno, @Param("c_id") Integer c_id)  throws Exception;

    @Transactional(rollbackFor = Exception.class)
    int write(CommentDto commentDto) throws Exception;

    List<CommentDto> getList(Integer bno) throws Exception;

    CommentDto read(Integer cno) throws Exception;

    int modify(CommentDto commentDto) throws Exception;
}
