package com.gl.jxt;



public class Department {
	@Override
	public String toString() {
		return "Department [type=" + type + ", name=" + name + ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3=" + ext3
				+ "]";
	}

	/**
	 * ������òID
	 */
	private String type;

	/**
	 * ������ò����
	 */
	private String name;

	/**
	 * ����ʱ��
	 */
	private String ext1;

	/**
	 * ��ע
	 */
	private String ext2;

	/**
	 * ��δʹ��
	 */
	private String ext3;
	
	/**
	 * ��ȡ������òID
	 * @return PS_TYPE - ������òID
	 */
	public String getType() {
		return type;
	}

	/**
	 * ����������òID
	 * @param type ������òID
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * ��ȡ������ò����
	 * @return PS_Name - ������ò����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����������ò����
	 * @param name ������ò����
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * ��ȡ����ʱ��
	 * @return Ext1 - ����ʱ��
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * ���ø���ʱ��
	 * @param ext1 ����ʱ��
	 */
	public void setExt1(final String ext1) {
		this.ext1 = ext1;
	}

	/**
	 * ��ȡ��ע
	 * @return Ext2 - ��ע
	 */
	public String getExt2() {
		return ext2;
	}

	/**
	 * ���ñ�ע
	 * @param ext2 ��ע
	 */
	public void setExt2(final String ext2) {
		this.ext2 = ext2;
	}

	/**
	 * ��ȡ��δʹ��
	 * @return Ext3 - ��δʹ��
	 */
	public String getExt3() {
		return ext3;
	}

	/**
	 * ������δʹ��
	 * @param ext3 ��δʹ��
	 */
	public void setExt3(final String ext3) {
		this.ext3 = ext3;
	}

	/** Default constructor */
	public Department() {
		this("1", "1", "1", "1", "1");
	}

	public Department(String type, String name, String ext1, String ext2, String ext3) {
		this.type = type;
		this.name = name;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
	}
}