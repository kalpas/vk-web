package net.kalpas.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Multimap;

import net.kalpas.VKCore.simple.DO.User;
import net.kalpas.VKCore.simple.helper.GMLHelper;
import net.kalpas.VKCore.stats.GroupStats;

@RestController
public class MainController {

	@Autowired
	private GroupStats groupStats;

	@RequestMapping("/group")
	public void groupStats(@RequestParam(value = "group", required = true) String group) {
		Multimap<User, User> multimap = groupStats.getMemberNetwork(group);
		GMLHelper.writeToFile(group + new Date().getTime(), multimap);
	}

}
