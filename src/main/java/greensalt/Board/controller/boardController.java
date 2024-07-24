package greensalt.Board.controller;

import greensalt.Board.domain.PageHandler;
import greensalt.Board.domain.BoardDto;
import greensalt.Board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class boardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("c_id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = boardService.remove(bno, writer);
            if(rowCnt!=1){
                throw new Exception("board remove error");}
            rattr.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
        return "redirect:/board/list";
    }



//    @GetMapping("/read")
//    public String read(Integer bno, Integer page, Integer pageSize, Model m){
//    try {
//        BoardDto boardDto = boardService.read(bno);
//        m.addAttribute(boardDto);
//        m.addAttribute("page", page);
//        m.addAttribute("pageSize", pageSize);
//    } catch (Exception e) {
//        throw new RuntimeException(e);
//    }
//
//    return "board";
//}

    @GetMapping("/list")
    public String board(Integer page, Integer pageSize, Model m, HttpServletRequest request) {

        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try {
            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page",page);
            m.addAttribute("pageSize",pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }






}







