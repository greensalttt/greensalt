package greensalt.customer.dao;

import greensalt.customer.domain.CustDto;
import greensalt.customer.domain.CustHistoryDto;

public interface CustDao {
    int deleteCust(String c_email) throws Exception;

    CustDto selectEmail(String c_email) throws Exception;

    /*리절트타입 CustDto 파마리터타입 int*/
    CustDto selectID(int c_id) throws Exception;

    int insert(CustDto custdto) throws Exception;

    int updateAll(CustDto custdto)throws Exception;

    int updatePwd(CustDto custDto) throws Exception;

    int deleteAll() throws Exception;

    int updateLoginDt(String c_email) throws Exception;

    CustDto grdNameJoin(int c_id) throws Exception;

    int visitCnt(String c_email) throws Exception;

    int insertCustHist(CustHistoryDto custHistoryDto) throws Exception;

}
