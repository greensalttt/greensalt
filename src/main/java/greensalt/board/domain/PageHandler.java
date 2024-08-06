package greensalt.board.domain;

public class PageHandler {


    private SearchCondition sc;
    private int totalCnt; //전체 게시물의 개수
    private int naviSize = 10; //navi의 크기
    private int totalPage; //전체 페이지의 개수
    private int beginPage; //navi의 시작페이지
    private int endPage; //navi의 끝페이지
    private boolean showPrev;
    private boolean showNext;


    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    public void doPaging(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize());
        beginPage = (sc.getPage()-1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

//    public String getQueryString() {
//        return getQueryString(this.sc.getPage());
//    }
//
//    public String getQueryString(Integer page) {
//        // ?page=10&pageSize=10&option=A&keyword=title
//        return UriComponentsBuilder.newInstance()
//                .queryParam("page",     page)
//                .queryParam("pageSize", sc.getPageSize())
//                .queryParam("option",   sc.getOption())
//                .queryParam("keyword",  sc.getKeyword())
//                .build().toString();
//    }


    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }
    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public void print() {
        System.out.println("page =" + sc.getPage());
        System.out.print(showPrev ? "[PREV] " : "");
        for(int i = beginPage; i<= endPage; i++){
            System.out.print(i+" ");

        }
        System.out.println(showNext ? " [NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}