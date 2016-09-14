package com.doc.entity;

import java.util.List;

import com.doc.util.EmojiFilter;

public class DocsApiWithBLOBs extends DocsApi {
    private String content;

    private String response;

    private String request;
    private List<DocsApiColumn> columns;
    
    public List<DocsApiColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DocsApiColumn> columns) {
		this.columns = columns;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : EmojiFilter.emojiFilter(response.trim());
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null :  EmojiFilter.emojiFilter(request.trim());
    }
}