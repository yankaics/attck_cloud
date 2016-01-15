package cn.attck.util;

public class PageUtil {
	// 每页显示的条数
	private int pageSize = 10;
	// 总共的条数
	private int number;
	// 当前页面
	private int page;

	// 构造方法
	public PageUtil(int number, int page) {
		this.number = number;
		this.page = page;
	}

	// 总页数
	public int getPageNumber() {
		// 总条数 / 每页显示的条数=总页数
		int size = number / pageSize;
		// 最后一页的条数
		int mod = number % pageSize;
		if (mod != 0) {
			size++;
		}
		return number == 0 ? 1 : size;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPage() {
		return page;
	}

}
