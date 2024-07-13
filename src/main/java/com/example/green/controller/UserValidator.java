package com.example.green.controller;

import com.example.green.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
        return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("UserValidator.validate() is called");

        User user = (User)target;

        String id = user.getId();
        String pwd = user.getPwd();
        String name = user.getName();
        String email = user.getEmail();
        String tel = user.getTel();
        String birth = user.getBirth();


//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");
//		}
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");


//        if (user.getName().isEmpty()) {
//            errors.rejectValue("name", "error.name", "이름을 입력하세요.");
//        }
//        if (user.getEmail().isEmpty()) {
//            errors.rejectValue("email", "error.email", "이메일을 입력하세요.");
//        }


        if ((id == null || !id.matches("^(?=.*[a-zA-Z]).{6,12}$")) && (pwd == null || !pwd.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$"))) {
            errors.rejectValue("id", "invalidCredentials", "아이디와 비밀번호 조건을 다시 확인해주세요.");
        } else {
            if (id == null || !id.matches("^(?=.*[a-zA-Z]).{6,12}$")) {
                errors.rejectValue("id", "invalidLength", new String[]{"6", "12"}, "아이디는 영문으로 {0}~{1}자 사이어야 합니다.");
            }
            if (pwd == null || !pwd.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$")) {
                errors.rejectValue("pwd", "invalidLength", new String[]{"6"}, "비밀번호는 영문/숫자 조합으로 {0}자 이상이어야합니다.");
            }
//            if (user.getName().isEmpty()) {
//                errors.rejectValue("name", "error.name", "빈칸을 채워주세요.");
//            }
//            if (user.getEmail().isEmpty()) {
//                errors.rejectValue("name", "error.name", "빈칸을 채워주세요.");
//            }
        }
}}