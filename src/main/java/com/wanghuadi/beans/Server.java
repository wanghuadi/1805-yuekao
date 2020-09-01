package com.wanghuadi.beans;

public class Server {
	   	private Integer id;//主键
	 	private String name;//服务名称
	 	private boolean flg;//true 选中  false  未选中
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Server(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Server() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public boolean isFlg() {
			return flg;
		}
		public void setFlg(boolean flg) {
			this.flg = flg;
		}
		@Override
		public String toString() {
			return "Server [id=" + id + ", name=" + name + "]";
		}
	 	
}
