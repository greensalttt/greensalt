//package board;
//
//import greensalt.Board.domain.PageHandler;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class PageHandlerTest{
//
//
//    @Test
//    public void test(){
//        PageHandler ph = new PageHandler(250, 1);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==1);
//        assertTrue(ph.getEndPage() ==10);
//    }
//
//    @Test
//    public void test2(){
//        PageHandler ph = new PageHandler(250, 11);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==11);
//        assertTrue(ph.getEndPage() ==20);
//    }
//
//    @Test
//    public void test3(){
//        PageHandler ph = new PageHandler(255, 25);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==21);
//        assertTrue(ph.getEndPage() ==26);
//    }
//
////    @Test
////    public void test2() {
////        PageHandler ph = new PageHandler(91, 5, 20);
////        System.out.println("ph="+ph);
////
////        assertTrue(ph.getNaviStart()==1);
////        assertTrue(ph.getNaviEnd()==5);
////    }
////
////    @Test
////    public void test() {
////        PageHandler ph = new PageHandler(2510, 16, 20);
////        System.out.println("ph="+ph);
////
////        assertTrue(ph.getNaviStart()==11);
////        assertTrue(ph.getNaviEnd()==20);
////    }
//}