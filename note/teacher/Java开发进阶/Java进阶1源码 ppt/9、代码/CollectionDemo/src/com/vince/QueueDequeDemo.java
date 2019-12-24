package com.vince;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue接口：队列，是一种先进先出的线性数据结构（排队）
 * LinkedList类实现了queue接口
 * 请求队列，消息队列，任务
 *
 * Deque接口：双端队列
 * Stack：堆栈 :先进后出
 * @author vince
 * @description
 */
public class QueueDequeDemo {
	// === Queue 接口 (队列) ===
	private static void queue(){
		Queue<String> queue = new LinkedList<>();
		// 入队
		queue.add("小花");
		queue.add("小黑");
		queue.add("小小");
		System.out.println(queue.size());
		// 获取但不移除此队列的头；如果此队列为空，则返回 null
		System.out.println(queue.peek());
		// 获取并移除此队列的头，如果此队列为空，则返回 null
		System.out.println(queue.poll());
	}
	// === Deque 接口 (双端队列) ===
	private static void deque(){
		Deque<String> deque = new LinkedList<>();
		deque.add("小花");
		deque.add("小黑");
		deque.add("小小");
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
	}
	// === Stack 类 (栈) ===
	private static void stack(){
		Stack<String> s = new Stack<>();
		// 压栈
		s.push("Bin");
		s.push("Tom");
		s.push("Lily");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	public static void main(String[] args) {
		// queue();
		// deque();
		stack();
	}
}
