//package com.example.green.dao;
//
//import com.example.green.domain.User;
//import org.junit.*;
//import org.junit.runner.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.test.context.*;
//import org.springframework.test.context.junit4.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class UserDaoImplTest {
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void insertUser() throws Exception {
//        userDao.deleteAll();
//        assertTrue(userDao.count()==0);
//
//        User user = new User("zzzz", "1234", "abc", "a@a.com", "010", "2010-01-01", new Date())
//    }
//}
