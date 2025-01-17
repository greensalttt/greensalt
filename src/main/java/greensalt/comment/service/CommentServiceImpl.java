package greensalt.comment.service;
import greensalt.board.dao.BoardDao;
import greensalt.comment.dao.CommentDao;
import greensalt.comment.domain.CommentDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    BoardDao boardDao;
    CommentDao commentDao;

//    @Autowired
    public CommentServiceImpl(CommentDao commentDao, BoardDao boardDao) {
        this.commentDao = commentDao;
        this.boardDao = boardDao;
    }

    @Override
    public int getCount(Integer bno) throws Exception {
        return commentDao.count(bno);
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int remove(Integer cno, Integer bno, Integer c_id) throws Exception {
//        int rowCnt = boardDao.updateCommentCnt(bno, -1);
//        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        rowCnt = commentDao.deleted(cno, c_id);
//        System.out.println("rowCnt = " + rowCnt);
//        return rowCnt;
//    }

//    Map 객체 사용
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int remove(Integer cno, Integer bno, Integer c_id) throws Exception {
//        int rowCnt = boardDao.updateCommentCnt(bno, -1);
//        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        Map<String, Object> params = new HashMap<>();
//        params.put("cno", cno);
//        params.put("c_id", c_id);
//        rowCnt = commentDao.deleted(params);
//        System.out.println("rowCnt = " + rowCnt);
//        return rowCnt;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int remove(Map<String, Object> params) throws Exception {
        int rowCnt = boardDao.updateCommentCnt((Integer) params.get("bno"), -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
        rowCnt = commentDao.deleted(params);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int write(CommentDto commentDto) throws Exception {
        boardDao.updateCommentCnt(commentDto.getBno(), 1);
        return commentDao.insert(commentDto);
    }

    @Override
    public List<CommentDto> getList(Integer bno) throws Exception {
        return commentDao.selectAll(bno);
    }

    @Override
    public CommentDto read(Integer cno) throws Exception {
        return commentDao.select(cno);
    }

    @Override
    public int modify(CommentDto commentDto) throws Exception {
        return commentDao.update(commentDto);
    }
}