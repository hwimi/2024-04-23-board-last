package handler;

import domain.PagingVO;

public class PaingHandler {
	//list 하단에 나오는 페이지네이션 핸들링 클래스
	private int startPage;// 현재화면에서 보여줄 시작 페이지네이션 번호 1 11 21 31 
	private int endPage;// 현재화면에서 보여줄 끝 페이지네이션 번호 10 20 30 ...
	private int realEndPage;//실제 전체 리스트의 마지막 페이지 번호
	private boolean prev; //이전 페이지의 존재여부 1x
	private boolean next; //다음 페이지의 존재여부  realEndPage X
	private PagingVO pgvo;// 파라미터로 현재 사용자가 클릭한 값을 받아오기
	private int totalCount;// DB에서 검색해오기-컨트롤러에서 받아오기
	
	public PaingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo=pgvo;
		this.totalCount=totalCount;
		
		//1~10/11~20/21~30
		//1 2 3 4 5 6 7 8 9 10=>10
		//pageNo/10=>0.1(올림)=>1*10=>10
		//11=>20/10=>1.1(올림)=>2*10=>20
		//11=>20
		//정수 / 정수 =정수 0.1형변환 필요
		this.endPage=(int)Math.ceil(pgvo.getPageNo() / (double)10)*10; // 맨뒤에 있는 10이라는 숫자는 페이징할때 1~10 이것을 나타내는것이다.
		this.startPage=this.endPage-9;
		//전체 게시글 수 / 한 화면에 표시되는 게시글 수
		//103 103/10 =>10.3=>11(올림)
		//나머지 게시글이 하나라도 있다면 1페이가 더 생겨야함.

		this.realEndPage =(int)Math.ceil(totalCount/(double)pgvo.getQty());
		
		//11~10 //11~20
		//실제 리얼 마지막 페이지가 11페이지라면 11끝
		//진짜 끝페이지가 endPage 와 같지 않을경우
		if(this.realEndPage<this.endPage) {
			this.endPage=this.realEndPage;
		}
		
		//이전 다음 유무
		this.prev=this.realEndPage>1;
		this.next=this.endPage<this.realEndPage;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PaingHandler [starPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", pgvo=" + pgvo + ", totalCount=" + totalCount + "]";
	}
	
	
}
