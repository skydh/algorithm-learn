package com.dh.stack;

/**
 * 浏览器的前进，后退功能，当点击新的页面时前进的数据就丢失了
 * 
 * ps:打开一个网页,点击新的超链接，原网页继续入栈a,继续点击新的超链接，原网页继续入栈a，继续点击新的超链接，原网页继续入栈a，点击后退，当前网页入栈b
 * ,a丢出一个页面。点击前进，当前页面入栈a,点开一个新的页面时，清空b栈。
 * 
 * @author Lenovo
 *
 */
public class Browser {

	/**
	 * 前栈a
	 */
	private OrderStack aHead;

	/**
	 * 后栈b
	 */
	private OrderStack back;

	/**
	 * 当前页面
	 */
	private int currentPage;

	public Browser(int value) {
		currentPage = value;
	}

	/**
	 * 点开新的超链接
	 * 
	 * @param value
	 */
	public void setPage(int value) {
		aHead.push(currentPage);
		currentPage = value;
		back.release();
	}

	/**
	 * 前进
	 */
	public void goAhead() {
		aHead.push(currentPage);
		currentPage = back.get();
	}

	/**
	 * 后退
	 */
	public void goBack() {
		back.push(currentPage);
		currentPage = aHead.get();

	}

}
