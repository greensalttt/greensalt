package greensalt.customer.service;

import greensalt.customer.dao.CustDao;
import greensalt.customer.domain.CustDto;
import greensalt.customer.domain.CustHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//@Component
@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustDao custDao;

    @Autowired
    private JavaMailSenderImpl mailSender;

    private int authNumber;

    public String emailCheck(String c_email) throws Exception {
        CustDto custDto = custDao.selectEmail(c_email);
        if (custDto == null) {
            return "ok";
        } else {
            return "no";
        }
    }

    /*비밀번호 암호화를 위해 메이븐에 스프링 시큐리티 코어 추가
    코어가 갖고 있는 BCryptPasswordEncoder 클래스 사용*/
    public String pwdEncrypt(String c_pwd) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(c_pwd);
    }


    public void makeRandomNumber() throws Exception {
//        랜덤 객체 생성
        Random r = new Random();
//        111111부터 999999까지 랜덤 난수 생성
        int checkNum = r.nextInt(888888) + 111111;
        System.out.println("인증번호 : " + checkNum);
//        생성된 변수를 authNumber에 저장
        authNumber = checkNum;
    }

    public String joinEmail(String c_email) throws Exception {
        makeRandomNumber();
        String setFrom = ".com"; // email-config에 설정한 자신의 이메일 주소를 입력
        String toMail = c_email;
        String title = "WELCOME GREEN :)"; // 이메일 제목
        String content = "고객님이 요청하신 인증번호는 " + authNumber + "입니다.";
        mailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);
    }


    public void mailSend(String setFrom, String toMail, String title, String content) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        // true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setFrom(setFrom);
        helper.setTo(toMail);
        helper.setSubject(title);
        // true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
        helper.setText(content, true);
        mailSender.send(message);
    }

    @Override
    public void custHist(CustDto custDto, CustDto oldData) throws Exception {
        // 회원 정보 업데이트
        custDao.updateAll(custDto);

        // 변경된 필드를 기록
        List<CustHistoryDto> historyList = new ArrayList<>();


        // 변경된 필드 체크 및 이력 추가
//        비밀번호 변경은 어떻게 이력 추가할것인가
//        addHistoryIfChanged(historyList, custDto, oldData, "PWD", oldData.getC_pwd(), custDto.getC_pwd());
        addHistoryIfChanged(historyList, custDto, oldData, "NM", oldData.getC_nm(), custDto.getC_nm());
        addHistoryIfChanged(historyList, custDto, oldData, "ROAD", oldData.getC_road_a(), custDto.getC_road_a());
        addHistoryIfChanged(historyList, custDto, oldData, "ZIP", oldData.getC_zip(), custDto.getC_zip());
        addHistoryIfChanged(historyList, custDto, oldData, "DET_A", oldData.getC_det_a(), custDto.getC_det_a());
        addHistoryIfChanged(historyList, custDto, oldData, "PHN", oldData.getC_phn(), custDto.getC_phn());
        addHistoryIfChanged(historyList, custDto, oldData, "BIRTH", oldData.getC_birth(), custDto.getC_birth());
        addHistoryIfChanged(historyList, custDto, oldData, "SMS", oldData.getSms_agr(), custDto.getSms_agr());
        addHistoryIfChanged(historyList, custDto, oldData, "EMAIL", oldData.getEmail_agr(), custDto.getEmail_agr());

        // 모든 변경 사항 이력 기록
        for (CustHistoryDto historyDto : historyList) {
            custDao.insertCustHist(historyDto);
        }
    }

    // 변경된 필드가 있는 경우에만 이력 추가
    private void addHistoryIfChanged(List<CustHistoryDto> historyList, CustDto newData, CustDto oldData,
                                     String changeCode, String oldValue, String newValue) {
        if (!oldValue.equals(newValue)) {
            CustHistoryDto historyDto = new CustHistoryDto();
            historyDto.setC_id(newData.getC_id());
            historyDto.setC_cng_cd(changeCode);
            historyDto.setC_bf(oldValue);
            historyDto.setC_af(newValue);
            historyList.add(historyDto);
        }
    }
}