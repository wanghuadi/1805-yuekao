package com.wanghuadi.beans;

/**
 * 活动实体
 * @author wanghd
 *
 */
public class Activity {
	  	private Integer id;// 主键
	  	private Integer activity_code;//  活动编号	
	    private Integer activity_type;// 活动分类	
	   	private String activity_name;//活动名称
	    private String start_time;//开始时间
	 	private String end_time;//   结束时间
		private String create_time;//    创建时间
		
		private String sname;//活动服务名称
		private String tname;//类型名称
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getActivity_code() {
			return activity_code;
		}
		public void setActivity_code(Integer activity_code) {
			this.activity_code = activity_code;
		}
		public Integer getActivity_type() {
			return activity_type;
		}
		public void setActivity_type(Integer activity_type) {
			this.activity_type = activity_type;
		}
		public String getActivity_name() {
			return activity_name;
		}
		public void setActivity_name(String activity_name) {
			this.activity_name = activity_name;
		}
		public String getStart_time() {
			return start_time;
		}
		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}
		public String getEnd_time() {
			return end_time;
		}
		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}
		public String getCreate_time() {
			return create_time;
		}
		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getTname() {
			return tname;
		}
		public void setTname(String tname) {
			this.tname = tname;
		}
		public Activity(Integer id, Integer activity_code, Integer activity_type, String activity_name,
				String start_time, String end_time, String create_time, String sname, String tname) {
			super();
			this.id = id;
			this.activity_code = activity_code;
			this.activity_type = activity_type;
			this.activity_name = activity_name;
			this.start_time = start_time;
			this.end_time = end_time;
			this.create_time = create_time;
			this.sname = sname;
			this.tname = tname;
		}
		public Activity() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Activity [id=" + id + ", activity_code=" + activity_code + ", activity_type=" + activity_type
					+ ", activity_name=" + activity_name + ", start_time=" + start_time + ", end_time=" + end_time
					+ ", create_time=" + create_time + ", sname=" + sname + ", tname=" + tname + "]";
		}
		
}
