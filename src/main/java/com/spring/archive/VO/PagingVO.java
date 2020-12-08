package com.spring.archive.VO;

public class PagingVO {
	
	private int nowPage;
	private int startPage;
	private int endPage;
	private int totalBoardCount;
	private int perPage = 5;
	private int lastPage;
	private int queryStart;
	private int queryEnd;
	private int maxPage = 5;
	private int categoryNo;
	private String search;
	
	public PagingVO() {}
	public PagingVO(int totalCountBoard, int nowPage, String search) {
		setSearch(search.trim());
		setNowPage(nowPage);
		setperPage(perPage);
		setTotalBoardCount(totalCountBoard);
		calcLastPage(getTotalBoardCount(), getPerPage());
		calcStartEndPage(getNowPage(), maxPage);
		calcStartEnd(getNowPage(), getPerPage());
	}
	
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}

	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}

	public void calcStartEnd(int nowPage, int cntPerPage) {
		setQueryEnd(nowPage * cntPerPage);
		setQueryStart(getQueryEnd() - cntPerPage);
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
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
	public int getTotalBoardCount() {
		return totalBoardCount;
	}
	public void setTotalBoardCount(int totalBoardCount) {
		this.totalBoardCount = totalBoardCount;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setperPage(int perPage) {
		this.perPage = perPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getQueryStart() {
		return queryStart;
	}
	public void setQueryStart(int queryStart) {
		this.queryStart = queryStart;
	}
	public int getQueryEnd() {
		return queryEnd;
	}
	public void setQueryEnd(int queryEnd) {
		this.queryEnd = queryEnd;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

}
