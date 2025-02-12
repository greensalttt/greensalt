package greensalt.customer.controller;
import greensalt.customer.dao.CustDao;
import greensalt.customer.domain.CustDto;
import greensalt.customer.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    CustDao custDao;
    @Autowired
    CustService custService;

    @GetMapping("/list")
    /*세션 속성에 저장되어있는 c_id를 가져와서 c_id 변수로 지정함*/
    public String myPage(HttpServletRequest request) {
        try {
            /*세션 객체 생성*/
            HttpSession session = request.getSession();

            /*세션에서 c_id를 가져와서 정수로 변환한 뒤 변수로 저장*/
            int c_id = (int) session.getAttribute("c_id");

            /*변수를 통해 db에 접근 후 dto에 저장*/
            CustDto custDto = custDao.grdNameJoin(c_id);

            /*세션 속성 설정*/
            if (custDto != null) {
                session.setAttribute("c_name", custDto.getC_name());
                session.setAttribute("c_nm", custDto.getC_nm());
                session.setAttribute("grd_name", custDto.getGrd_name());
                session.setAttribute("tot_amt", custDto.getTot_amt());
                session.setAttribute("visit_cnt", custDto.getVisit_cnt());

                Date regDate = custDto.getReg_dt();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String regDateStr = dateFormat.format(regDate);
                session.setAttribute("reg_dt", regDateStr);
            }
            return "myPage";
        } catch (Exception e) {
            return "errorPageC";
        }
    }


    @GetMapping("/info")
    public String myPageInfo(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            int c_id = (int) session.getAttribute("c_id");
            CustDto custDto = custDao.selectID(c_id);

            if (custDto != null) {
                session.setAttribute("c_email", custDto.getC_email());
                session.setAttribute("c_name", custDto.getC_name());
                session.setAttribute("c_nm", custDto.getC_nm());
                session.setAttribute("c_zip", custDto.getC_zip());
                session.setAttribute("c_road_a", custDto.getC_road_a());
                session.setAttribute("c_jibun_a", custDto.getC_jibun_a());
                session.setAttribute("c_det_a", custDto.getC_det_a());
                session.setAttribute("c_phn", custDto.getC_phn());
                session.setAttribute("c_gnd", custDto.getC_gnd());
                session.setAttribute("c_birth", custDto.getC_birth());
                session.setAttribute("sms_agr", custDto.getSms_agr());
                session.setAttribute("email_agr", custDto.getEmail_agr());
            }
            return "myPageInfo";
        } catch (Exception e) {
            return "errorPageC";
        }
    }

    @InitBinder("myPageInfoValidator")
    //*유효성 검사를 위해 WebDataBinder클래스의 객체를 사용*//*
    public void custValid(WebDataBinder binder) {
        //*객체를 통해 새로운 Validator인 CustValidator를 등록*//*
        binder.setValidator(new MyPageInfoValidator());
    }

    @PostMapping("/info")
    public String modify(@Validated @ModelAttribute("myPageInfoValidator") CustDto custDto, BindingResult result, HttpServletRequest request) {
        try {
            if (result.hasErrors()) {
                return "myPageInfo";
            }

            HttpSession session = request.getSession();
            int c_id = (int) session.getAttribute("c_id");

            // 기존 데이터 조회
            CustDto oldData = custDao.selectID(c_id);

            // 현재 데이터 설정
            custDto.setC_id(c_id);

            // 서비스 호출하여 정보 업데이트 및 이력 기록
            custService.custHist(custDto, oldData);

            return "redirect:/mypage/list";
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPageC";
        }
    }

    @GetMapping("/pwdEdit")
    public String pwdEdit() {
        return "pwdEdit";
    }

    @InitBinder("PwdChangeValidator")
    /*유효성 검사를 위해 WebDataBinder클래스의 객체를 사용*/
    public void pwdValid(WebDataBinder binder) {
        /*객체를 통해 새로운 Validator인 CustValidator를 등록*/
        binder.setValidator(new PwdChangeValidator());
    }

    @PostMapping("/pwdEdit")
    public String pwdModify(@Validated @ModelAttribute("PwdChangeValidator") CustDto custDto, BindingResult result, HttpServletRequest request, String c_pwd, String curPwd, RedirectAttributes msg) {
        /*System.out.println("자스를 통과한 에러가 있나요?! = " + result);*/

        try {
            System.out.println("자스를 통과한 에러가 있나요?! = " + result);

            if (result.hasErrors()) {
                return "pwdEdit";
            }

            HttpSession session = request.getSession();
            int c_id = (int) session.getAttribute("c_id");

            /*현재 로그인한 사용자의 실제 비밀번호 가져오기*/
            custDto = custDao.selectID(c_id);
            String actualPwd = custDto.getC_pwd();

            /* 입력한 현재 비밀번호와 실제 비밀번호가 일치하는지 확인*/
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(curPwd, actualPwd)) {
                msg.addFlashAttribute("pwdFail", "pwdMsg");
                return "redirect:/mypage/pwdEdit";
            }

            // 기존 데이터 조회
            CustDto oldData = custDao.selectID(c_id);
            /* 현재 비밀번호가 일치하면 새로운 비밀번호로 업데이트*/
            custDto.setC_id(c_id);
            custDto.setC_pwd(custService.pwdEncrypt(c_pwd));
            custService.custHistPwd(custDto, oldData);
            msg.addFlashAttribute("pwdClear", "pwdMsg2");
            session.invalidate();
            // 서비스 호출하여 정보 업데이트 및 이력 기록
            return "redirect:/login";

        } catch (Exception E) {
            return "errorPageC";
        }
    }
}