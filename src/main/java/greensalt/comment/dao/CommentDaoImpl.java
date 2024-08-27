package greensalt.comment.dao;

import greensalt.comment.domain.CommentDto;
import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "green.mapper.commentMapper.";

    @Override
    public int count(Integer bno) throws Exception {
        return session.selectOne(namespace+"count", bno);
    }

    @Override
    public int deleteAll(Integer bno) {
        return session.delete(namespace+"deleteAll", bno);
    }

    @Override
    public int insert(CommentDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }

    @Override
    public List<CommentDto> selectAll(Integer bno) throws Exception {
        return session.selectList(namespace+"selectAll", bno);
    }

    @Override
    public CommentDto select(Integer cno) throws Exception {
        return session.selectOne(namespace + "select", cno);
    }

    @Override
    public int update(CommentDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }

@Override
public int deleted(Map<String, Object> params) throws Exception {
    return session.update(namespace + "deleted", params);
}
}