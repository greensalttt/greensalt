package greensalt.board.dao;

import greensalt.board.domain.BoardDto;
import greensalt.board.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int count() throws Exception // T selectOne(String statement)
    ;

    int deleteAll() // int delete(String statement)
    ;

    int insert(BoardDto dto) throws Exception // int insert(String statement, Object parameter)
    ;

    List<BoardDto> selectAll() throws Exception // List<E> selectList(String statement)
    ;

    BoardDto select(Integer bno) throws Exception // T selectOne(String statement, Object parameter)
    ;

    List<BoardDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;

    int update(BoardDto dto) throws Exception // int update(String statement, Object parameter)
    ;

    int increaseViewCnt(Integer bno) throws Exception // int update(String statement, Object parameter)
    ;


    List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;


    int searchResultCnt(SearchCondition sc) throws Exception;

    int updateCommentCnt(Integer bno, int cnt);


    // 이름 SQL문과 안맞춰도됨

    int deleted(Integer bno, Integer c_id) throws Exception;

}
