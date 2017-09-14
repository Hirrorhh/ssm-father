package cn.ssm.usermanager.pojo;

import java.util.List;

public class UiDataResult<T> {

	private List<T> rows;
	
	private Long total;

	public UiDataResult() {
		super();
	}

	public UiDataResult(List<T> rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
}
