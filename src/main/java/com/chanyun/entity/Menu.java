package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("菜单栏实体类")
public class Menu {
	@ApiModelProperty(value="id",readOnly=true )
    private Integer id;
	@ApiModelProperty(value="icon样式")
    private String icon;
	@ApiModelProperty(value="菜单名称")
    private String name;
	@ApiModelProperty(value="菜单状态   1启用 2禁用  99删除")
    private Integer state;
	@ApiModelProperty(value="菜单url")
    private String url;
	@ApiModelProperty(value="父级id -1为一级菜单")
    private Integer parentId;
	@ApiModelProperty(value="排序",example="1")
	private int sort;
	@ApiModelProperty(value="父级菜单",example="系统设置")
	private String parentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
    
    
}