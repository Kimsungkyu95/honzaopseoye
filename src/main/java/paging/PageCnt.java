package paging;

/**
 * 페이징 정보를 담고있는 class
 * */
public class PageCnt {
	private static int pageCnt; //총페이지 수Math.ceil(전체레코드수 /pagesize) 
	public static  int pagesize = 10;// 한 페이지 당 10개 출력물
	public static int pageNo=1;// 현재 페이지 번호
	
	public  int blockcount=5; //한 블럭당 보여질 페이지 수
	
	//String keyField;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageCnt) {
		super();
		PageCnt.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		PageCnt.pageCnt = pageCnt;
	}

	public static int getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		PageCnt.pagesize = pagesize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		PageCnt.pageNo = pageNo;
	}

	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	
}
