/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
public class NoticeBoard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NoticeBoardId")
    private Integer noticeBoardId;
    @Temporal(TemporalType.DATE)
    @Column(name = "NoticeStartDate")
    private Date noticeStartDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "NoticeEndDate")
    private Date noticeEndDate;
    @Size(max = 500)
    @Column(name = "Notice")
    private String notice;

    public Integer getNoticeBoardId() {
        return noticeBoardId;
    }

    public void setNoticeBoardId(Integer noticeBoardId) {
        this.noticeBoardId = noticeBoardId;
    }

    public Date getNoticeStartDate() {
        return noticeStartDate;
    }

    public void setNoticeStartDate(Date noticeStartDate) {
        this.noticeStartDate = noticeStartDate;
    }

    public Date getNoticeEndDate() {
        return noticeEndDate;
    }

    public void setNoticeEndDate(Date noticeEndDate) {
        this.noticeEndDate = noticeEndDate;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

}
