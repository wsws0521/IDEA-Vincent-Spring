package cn.itcast.property;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyDemo3 {
	private String name;
	private String[] arrs;
	private List<String> list;
	private Map<String, String> map;
	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	private Properties prop;

	public void setName(String name) {
		this.name = name;
	}
	
	public void test3(){
		System.out.println("pname:" + name);
		System.out.println("arrs:" + arrs);
		System.out.println("list:" + list);
		System.out.println("map:" + map);
		System.out.println("Properties:" + prop);
	}
}
