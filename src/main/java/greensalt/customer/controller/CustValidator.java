package greensalt.customer.controller;

import greensalt.customer.domain.CustDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustValidator implements Validator {


    @Override
    /*supports는 객체(clazz)가 검증이 가능한지 알려주는 Validator의 메서드임*/
    public boolean supports(Class<?> clazz) {
        /*CustDto 타입만 검증한다*/
		return CustDto.class.equals(clazz);
    }

    @Override
    /*target: 검증할 객체, errors: 검증시 발생한 저장소*/
    /*validate 유효성 검사 메서드*/
    public void validate(Object target, Errors errors) {
        System.out.println("서버에서 검사할게요!");
        /*처음 설정이 오브젝트 타겟으로 되있어서 CustDto로 변경해줘야함*/
        CustDto custDto = (CustDto)target;
        String c_email = custDto.getC_email();
        String c_pwd = custDto.getC_pwd();
        String c_phn = custDto.getC_phn();



        if (c_email == null || !c_email.matches("^((?![가-힣]).)*([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")) {
            errors.rejectValue("c_email", "invalidCredentials", "이메일 뚫림?");
        }
        if (c_pwd == null || !c_pwd.matches("^(?=.*\\d)(?=.*[a-z])[a-z0-9]{4,15}$")) {
            errors.rejectValue("c_pwd", "invalidLength", "비밀번호 뚫림" );
        }
        if (c_phn == null || !c_phn.matches("^[0-9]{11,12}$")) {
            errors.rejectValue("c_phn", "invalidLength", "핸드폰 뚫림?" );
    }
    }}


