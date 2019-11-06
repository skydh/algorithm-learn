package com.dh.leetcode3;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点
 * （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 /
 * 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入："/home/" 输出："/home" 解释：注意，最后一个目录名后面没有斜杠。 示例 2：
 * 
 * 输入："/../" 输出："/" 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。 示例 3：
 * 
 * 输入："/home//foo/" 输出："/home/foo" 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。 示例 4：
 * 
 * 输入："/a/./b/../../c/" 输出："/c" 示例 5：
 * 
 * 输入："/a/../../b/../c//.//" 输出："/c" 示例 6：
 * 
 * 输入："/a//b////c/d//././/.." 输出："/a/b/c"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SimplifyPath {
	/**
	 * 总结，去掉. 和.. 以及//这种多情况
	 * 
	 * @param path
	 * @return
	 */
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < path.length(); i++) {
			char temp = path.charAt(i);
			/**
			 * 无论如何，必须以/开头
			 */
			if (stack.size() == 0) {
				if (temp == '/')
					stack.add(String.valueOf(temp));
			} else {
				String tempStr = stack.pop();

				if (temp == '/') {
					if (tempStr.equals("/"))
						stack.add("/");
					else if (tempStr.equals(".")) {
					} else if (tempStr.equals("..")) {
						if (stack.size() > 0) {
							stack.pop();
						}
						if (stack.size() > 0) {
							stack.pop();
						}
						if (stack.size() == 0) {
							stack.add("/");
						}
					} else {
						stack.add(tempStr);
						stack.add("/");
					}

				} else {
					if (!tempStr.equals("/"))
						stack.add(tempStr + temp);
					else {
						stack.add(tempStr);
						stack.add(String.valueOf(temp));
					}

				}
			}
		}
		String temp = stack.pop();
		if (temp.equals("..")) {

			if (stack.size() > 0) {
				stack.pop();
			}
			if (stack.size() > 0) {
				stack.pop();
			}
			if (stack.size() == 0) {
				stack.add("/");
			}
		} else if (temp.equals(".")) {
			stack.pop();
		} else {
			stack.add(temp);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			if (i == stack.size() - 1 && stack.get(i) == "/" && stack.size() > 1)
				break;
			sb.append(stack.get(i));
		}

		if (sb.length() == 0)
			sb.append("/");
		return sb.toString();

	}

	public static void main(String[] args) {

		System.out.println(simplifyPath("/."));
	}

}
