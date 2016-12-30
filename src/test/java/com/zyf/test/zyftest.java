package com.zyf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class zyftest {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		Map map3 = new HashMap();

		map3.put("date", l); // 向列表中添加数据

		Map build = new HashMap();
		build.put("msg", "ok");
		build.put("retcode", "0");
		build.putAll(map3);

		System.out.println("第一个build集合大小为：" + map3.toString());

		System.out.println("map:" + JSONObject.toJSONString(build));

	}
}
