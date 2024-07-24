package customer;

import greensalt.customer.domain.CustDto;
import greensalt.customer.dao.CustDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class CustDaoImplTest {
    @Autowired
    private CustDao custDao;


    @Test
    public void deleteCust() {
    }

    @Test
    public void selectEmail() {
    }

    @Test
    public void insert() throws Exception{
        custDao.deleteAll();
        CustDto custDto = new CustDto("asdf", "1234", "홍길동", "1990-01-01", "M", "0100100100", "123456", "서울특별시 강남구 테헤란로", "123번지", "101동 202호", "Y", "Y");
        int rowCnt = custDao.insert(custDto);
        assertTrue(rowCnt==1);
    }



    @Test
    public void updateAll() throws Exception{
        /*DB에서 아이디 100056번인 고객의 정보를 Dto에 저장*/
        CustDto custDto = custDao.selectID(100056);

        /*그 고객의 이름을 변경*/
        custDto.setC_name("흥흥흥");
        custDto.setC_phn("9999");

        /* 수정된 정보를 데이터베이스에 업데이트 */
        int rowCnt = custDao.updateAll(custDto);
        /* 업데이트가 성공적으로 수행되었는지 확인 */
        assertTrue(rowCnt == 1);
    }

}