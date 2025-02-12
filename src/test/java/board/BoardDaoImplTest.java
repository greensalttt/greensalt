package board;

import greensalt.board.dao.BoardDao;
import greensalt.board.domain.BoardDto;
import greensalt.board.domain.SearchCondition;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    private BoardDao boardDao;

    @Test
    public void insertTestData() throws Exception{
        boardDao.deleteAll();
        for(int i = 1; i<= 100; i++){
            BoardDto boardDto = new BoardDto(12341234,"title"+i, "asdfasdfasdf", "asdf"+i,0);
            boardDao.insert(boardDto);
        }
    }

    @Test
    public void deleteTest() throws Exception {
        boardDao.deleteAll();
    }

    @Test
    public void countTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==2);
    }

    @Test
    public void deleteAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);
        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);

        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.deleteAll()==1);
        assertTrue(boardDao.count()==0);

       boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.deleteAll()==2);
        assertTrue(boardDao.count()==0);
    }

    //
    @Test
    public void insertTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);

        boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==2);

        boardDao.deleteAll();
        boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);
    }

    // 게시글 한개만 추가 (이전 게시글 삭제 안함)
    @Test
    public void insertTest2() throws Exception {
        // 현재 게시글의 수를 저장합니다.
        int initialPostCount = boardDao.count();

        // 새로운 게시글 추가
        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto) == 1);


        // 추가한 게시글의 수가 1 증가했는지 확인합니다.
        assertTrue(boardDao.count() == initialPostCount + 1);
    }

    @Test
    public void insertMultiplePostsTest() throws Exception {
        // 현재 게시글의 수를 저장합니다.
        int initialPostCount = boardDao.count();

        // 10개의 새로운 게시글을 추가
        for (int i = 1; i < 101; i++) {
            BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
            assertTrue(boardDao.insert(boardDto) == 1);
        }

        // 추가한 게시글의 수가 20개 증가했는지 확인합니다.
        assertTrue(boardDao.count() == initialPostCount + 100);
    }

    @Test
    public void selectAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);
//
        List<BoardDto> list = boardDao.selectAll();
        assertTrue(list.size() == 0);

        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);

        list = boardDao.selectAll();
        assertTrue(list.size() == 1);

        assertTrue(boardDao.insert(boardDto)==1);
        list = boardDao.selectAll();
        assertTrue(list.size() == 2);
    }


    @Test
    public void select() throws Exception{
        assertTrue(boardDao != null);
        System.out.println("boardDao = " + boardDao);
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }

    @Test
    public void selectPageTest() throws Exception {
        boardDao.deleteAll();

        for (int i = 1; i <= 10; i++) {
            BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
            boardDao.insert(boardDto);
        }

        Map map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 3);

        List<BoardDto> list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));
        assertTrue(list.get(1).getTitle().equals("9"));
        assertTrue(list.get(2).getTitle().equals("8"));

        map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 1);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));

        map = new HashMap();
        map.put("offset", 7);
        map.put("pageSize", 3);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("3"));
        assertTrue(list.get(1).getTitle().equals("2"));
        assertTrue(list.get(2).getTitle().equals("1"));
    }

    @Test
    public void updateTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        System.out.println("bno = " + bno);
        boardDto.setBno(bno);
        boardDto.setTitle("yes title");
        assertTrue(boardDao.update(boardDto)==1);

        BoardDto boardDto2 = boardDao.select(bno);
        assertTrue(boardDto.equals(boardDto2));
    }

    @Test
    public void increaseViewCntTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto(12341234, "title" + 1, "no content",  "닉네임", 0);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.increaseViewCnt(bno)==1);

        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 1);

        assertTrue(boardDao.increaseViewCnt(bno)==1);
        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 2);
    }


    @Test
    public void searchSelectPageTest() throws Exception {
        boardDao.deleteAll();
        for (int i = 1; i <= 20; i++) {
            BoardDto boardDto = new BoardDto(12341234,"title"+i, "asdfasdfasdf", "asdf"+i,0);
            boardDao.insert(boardDto);
        }

        SearchCondition sc = new SearchCondition(1, 10, "title2", "T");
        List<BoardDto> list = boardDao.searchSelectPage(sc);
        System.out.println("list = " + list);
        assertTrue(list.size()==2);

        sc = new SearchCondition(1, 10, "asdf2", "W");
        list = boardDao.searchSelectPage(sc);
        System.out.println("list = " + list);
        assertTrue(list.size()==2);
    }

    @Test
    public void searchResultCntTest() throws Exception {
        boardDao.deleteAll();
        for (int i = 1; i <= 20; i++) {
            BoardDto boardDto = new BoardDto(12341234, "title" + i, "no content",  "닉네임", 0);
            boardDao.insert(boardDto);
        }

        SearchCondition sc = new SearchCondition(1, 10, "title2", "T");
        int cnt = boardDao.searchResultCnt(sc);
        System.out.println("cnt = " + cnt);
        assertTrue(cnt==2);

        sc = new SearchCondition(1, 10, "asdf2", "W");
        cnt = boardDao.searchResultCnt(sc);
        System.out.println("cnt = " + cnt);
        assertTrue(cnt==2);
    }
}