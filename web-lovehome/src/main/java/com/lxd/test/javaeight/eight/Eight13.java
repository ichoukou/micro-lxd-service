package com.lxd.test.javaeight.eight;

import static java.util.stream.Collectors.groupingBy;
import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.lxd.test.javaeight.mo.Apple;
import com.lxd.test.javaeight.mo.CaloricLevel;
import com.lxd.test.javaeight.mo.Dish;

/**
 * 8.1.3 从 Lambda 表达式到方法引用的转换 ，为了改善代码的可读性，也请 尽量使用方法引用。因为方法名往往能更直观地表达代码的意图
 * 
 * @author li_xiaodong
 *
 */
public class Eight13 {

	public static void main(String[] args) {

		/**
		 * 按照食物的热量级别对菜肴进行分类
		 */
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(groupingBy(dish -> {

			if (dish.getCalories() < 400) {
				return CaloricLevel.DIET;
			} else if (dish.getCalories() <= 700) {
				return CaloricLevel.NORMAL;
			} else {
				return CaloricLevel.FAT;
			}
		}));

		/**
		 * 将 Lambda 表达式 抽取到一个方法内
		 */
		Dish.menu.stream().collect(groupingBy(Dish::getCaloricLevel));

		/**
		 * 除此之外，我们还应该尽量考虑使用静态辅助方法，比如comparing、maxBy。这些方法设 计之初就考虑了会结合方法引用一起使用。
		 */
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		//你需要考虑如何实现比较算法
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		//读起来就像问题描述，非常清晰
		inventory.sort(comparing(Apple::getWeight));
		
	}

}
