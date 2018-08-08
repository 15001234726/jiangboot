package com.jyh.jiangboot;

import com.jyh.jiangboot.cyLunch.entity.Restaurant;
import com.jyh.jiangboot.cyLunch.mapper.RestaurantMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiangbootApplicationTests {

	@Resource
	private RestaurantMapper restaurantMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void selectAll(){
		List<Restaurant> list = restaurantMapper.selectAllRestaurant();

		for (Restaurant restaurant : list) {
			System.out.println(restaurant);
		}

	}

}
