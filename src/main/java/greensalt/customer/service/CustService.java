package greensalt.customer.service;

import greensalt.customer.domain.CustDto;

public interface CustService {

    /*이메일 중복체크*/
    String emailCheck(String c_email) throws Exception;


    /*비밀번호 암호화*/
    String pwdEncrypt(String c_pwd) throws Exception;


    String joinEmail(String c_email) throws Exception;

    void custHist(CustDto custDto, CustDto oldData) throws Exception;

    void custHistPwd(CustDto custDto, CustDto oldData) throws Exception;

}





