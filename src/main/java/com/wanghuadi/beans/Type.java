package com.wanghuadi.beans;

public class Type {
	  	private Integer id;// 主键
	  	private String activity_name;// 分类名称
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getActivity_name() {
			return activity_name;
		}
		public void setActivity_name(String activity_name) {
			this.activity_name = activity_name;
		}
		public Type(Integer id, String activity_name) {
			super();
			this.id = id;
			this.activity_name = activity_name;
		}
		public Type() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Type [id=" + id + ", activity_name=" + activity_name + "]";
		}
	  	
}
