package com.doc.entity;

public class DocsApiColumn {
    private Long id;
    private Long apiId;

    private String coTitle;

    private String coType;

    private String coNote;

    private String img;

    private String url;

    private String note;

    private Integer addTime;

    private Integer type;

    private Integer status;

    public Long getId() {
        return id;
    }

    public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getCoTitle() {
        return coTitle;
    }

    public void setCoTitle(String coTitle) {
        this.coTitle = coTitle == null ? null : coTitle.trim();
    }

    public String getCoType() {
        return coType;
    }

    public void setCoType(String coType) {
        this.coType = coType == null ? null : coType.trim();
    }

    public String getCoNote() {
        return coNote;
    }

    public void setCoNote(String coNote) {
        this.coNote = coNote == null ? null : coNote.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}