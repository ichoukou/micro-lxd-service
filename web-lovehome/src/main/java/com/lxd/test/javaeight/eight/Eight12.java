package com.lxd.test.javaeight.eight;

/**
 * 8.1.2 从匿名类到 Lambda 表达式的转换
 * @author li_xiaodong
 *
 */
public class Eight12 {

	public static void main(String[] args) {

		/**
		 * 现在，你再传递一个匿名类实现的Task，不会碰到任何问题：
		 */
		doSomething(new Task() {

			@Override
			public void excute() {
				System.out.println("Danger danger!!");
			}
		});

		/**
		 * 在涉及重载的上下文里，将匿名类转换为Lambda表达式可能导致最终的代码更加晦
		 * 涩。实际上，匿名类的类型是在初始化时确定的，而Lambda的类型取决于它的上下文。通过下
		 * 面这个例子，我们可以了解问题是如何发生的。我们假设你用与Runnable同样的签名声明了一
		 * 个函数接口，我们称之为Task（你希望采用与你的业务模型更贴切的接口名时，就可能做这样 的变更）：
		 */
		/**
		 * 但是将这种匿名类转换为Lambda表达式时，就导致了一种晦涩的方法调用，因为Runnable 和Task都是合法的目标类型：
		 */
		// doSomething(() -> System.out.println("Danger danger!!"));

		/**
		 * 你可以对Task尝试使用显式的类型转换来解决这种模棱两可的情况
		 * 但是不要因此而放弃对Lambda的尝试。好消息是，目前大多数的集成开发环境，比如NetBeans
		 * 和IntelliJ都支持这种重构，它们能自动地帮你检查，避免发生这些问题
		 */
		doSomething((Task) () -> System.out.println("Danger danger!!"));

	}

	/**
	 * 匿名类的lambda写法
	 */
	public void runable() {

		// 匿名类
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("hello");
			}
		};
		// 匿名类的lambda写法
		Runnable r2 = () -> System.out.println("hello");

	}

	/**
	 * 首先，匿名 类和Lambda表达式中的this和super的含义是不同的。在匿名类中，this代表的是类自身，但
	 * 是在Lambda中，它代表的是包含类。其次，匿名类可以屏蔽包含类的变量
	 */
	public void runable2() {

		// int a = 10;

		Runnable r1 = () -> {

			int a = 2;
			System.out.println("hello");

		};

		Runnable r2 = () -> {
			int a = 2;
			System.out.println("hello");
		};

	}

	/**
	 * 
	 * @param r
	 */
	public static void doSomething(Runnable r) {
		r.run();
	}

	public static void doSomething(Task a) {
		a.excute();
	}
}
