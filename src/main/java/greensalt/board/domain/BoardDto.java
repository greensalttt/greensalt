package greensalt.board.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private  Integer bno;
    private  Integer c_id;
    private  String title;
    private  String content;
    private  String writer;
    private  int view_cnt;
    private  int comment_cnt;
    private Date reg_date;
    public BoardDto(){}
    public BoardDto(String title, Integer c_id, String content, String writer) {
        this.c_id = c_id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

//    public BoardDto(Integer bno, Integer c_id) {
//        this.bno = bno;
//        this.c_id = c_id;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BoardDto boardDto = (BoardDto) o;
//        return Objects.equals(bno, boardDto.bno) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(writer, boardDto.writer);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(bno, c_id, title, content, writer);
//    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", c_id='" + c_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", view_cnt=" + view_cnt +
                ", comment_cnt=" + comment_cnt +
                ", reg_date=" + reg_date +
                '}';
    }

    public Integer getBno() { return bno; }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Integer getC_id() { return c_id; }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}
