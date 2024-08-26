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
    } // T selectOne(String statement)

    @Override
    public int deleteAll(Integer bno) {
        return session.delete(namespace+"deleteAll", bno);
    } // int delete(String statement)

    @Override
    public int insert(CommentDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)

    @Override
    public List<CommentDto> selectAll(Integer bno) throws Exception {
        return session.selectList(namespace+"selectAll", bno);
    } // List<E> selectList(String statement)

    @Override
    public CommentDto select(Integer cno) throws Exception {
        return session.selectOne(namespace + "select", cno);
    } // T selectOne(String statement, Object parameter)

    @Override
    public int update(CommentDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)

//    @Override
//    public int deleted(Integer cno, Integer c_id) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("cno", cno);
//        map.put("c_id", c_id);
//        return session.update(namespace + "deleted", map);
//    }
@Override
public int deleted(Map<String, Object> params) throws Exception {
    return session.update(namespace + "deleted", params);
}
}