package greensalt.comment.controller;
import greensalt.comment.domain.CommentDto;
import greensalt.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//RESTful은 HTTP 메서드(GET, POST, PUT, DELETE, PATCH)를 사용하여 클라이언트와 서버간의 데이터를 주고 받는 형식
@RestController
public class CommentController {
    @Autowired
    CommentService service;

    // 댓글을 수정하는 메서드
    @PatchMapping("/comments/{cno}")
    public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentDto dto, HttpSession session) {
        Integer c_id = (Integer) session.getAttribute("c_id");
        dto.setC_id(c_id);
        dto.setCno(cno);
        System.out.println("dto = " + dto);

        try {
            if(service.modify(dto)!=1)
                throw new Exception("Write failed.");

            return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("MOD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글을 등록하는 메서드
    @PostMapping("/comments")
    public ResponseEntity<String> write(@RequestBody CommentDto dto, Integer bno, HttpSession session) {
//        Integer commenter = (Integer) session.getAttribute("c_id");
//        dto.setCommenter(String.valueOf(commenter));
        Integer c_id = (Integer) session.getAttribute("c_id");
        dto.setC_id(c_id);
        dto.setCommenter((String) session.getAttribute("c_nm"));
        dto.setBno(bno);
        System.out.println("dto = " + dto);

        try {
            if(service.write(dto)!=1)
                throw new Exception("Write failed.");
            return new ResponseEntity<>("WRT_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("WRT_ERR", HttpStatus.BAD_REQUEST);
        }
    }

//    // 지정된 댓글을 삭제하는 메서드
//    @DeleteMapping("/comments/{cno}")
//    public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
//        Integer c_id = (Integer) session.getAttribute("c_id");
//        try {
//            int rowCnt = service.remove(cno, bno, c_id);
//
//            if(rowCnt!=1)
//                throw new Exception("Delete Failed");
//
//            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
//        }
//    }

    // 지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{cno}")
    public ResponseEntity<String> remove(@PathVariable Integer cno, @RequestParam Integer bno, HttpSession session) {
        Integer c_id = (Integer) session.getAttribute("c_id");
        try {
            // 파라미터를 Map에 담음
            Map<String, Object> params = new HashMap<>();
            params.put("cno", cno);
            params.put("bno", bno);
            params.put("c_id", c_id);

            // Map을 서비스 메서드에 전달
            int rowCnt = service.remove(params);

            if (rowCnt != 1) {
                throw new Exception("Delete Failed");
            }

            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }
    }


    // 지정된 게시물의 모든 댓글을 가져오는 메서드
    @GetMapping("/comments")
    public ResponseEntity<List<CommentDto>> list(Integer bno) {
        List<CommentDto> list = null;
        try {
            list = service.getList(bno);
            System.out.println("list = " + list);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);  // 200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST); // 400
        }
    }
}