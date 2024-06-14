package com.trongphu.ticketmovie.dto.respone;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Trong Phu on 6/8/2024 16:19:08
 *
 * @author Trong Phu
 */
public class ResponsePageData extends ResponseData{

    private long totalItems;

    public ResponsePageData(int status, String message) {
        super(status, message);
    }

    public ResponsePageData(int status, String message, Object data, long totalItems) {
        super(status, message, data);
        this.totalItems = totalItems;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
