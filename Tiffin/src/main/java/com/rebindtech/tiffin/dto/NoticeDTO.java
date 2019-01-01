/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

/**
 *
 * @author mrsagar
 */
public class NoticeDTO {

    private String noticeStartDate;
    private String noticeEndDate;
    private String noticeId;
    private String notice;

    public String getNoticeStartDate() {
        return noticeStartDate;
    }

    public void setNoticeStartDate(String noticeStartDate) {
        this.noticeStartDate = noticeStartDate;
    }

    public String getNoticeEndDate() {
        return noticeEndDate;
    }

    public void setNoticeEndDate(String noticeEndDate) {
        this.noticeEndDate = noticeEndDate;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

}
