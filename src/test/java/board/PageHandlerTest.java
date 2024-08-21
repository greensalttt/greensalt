package board;

import greensalt.board.domain.PageHandler;
import greensalt.board.domain.SearchCondition;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageHandlerTest{


    @Test
    public void test(){
        SearchCondition sc = new SearchCondition(1, 10, "", "");
        PageHandler ph = new PageHandler(250, sc);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==1);
        assertTrue(ph.getEndPage() ==10);
    }

    @Test
    public void test2(){
        SearchCondition sc = new SearchCondition(11, 10, "", "");
        PageHandler ph = new PageHandler(250, sc);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==11);
        assertTrue(ph.getEndPage() ==20);
    }

    @Test
    public void test3(){
        SearchCondition sc = new SearchCondition(25, 10, "", "");
        PageHandler ph = new PageHandler(250, sc);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==21);
        assertTrue(ph.getEndPage() ==26);
    }

}