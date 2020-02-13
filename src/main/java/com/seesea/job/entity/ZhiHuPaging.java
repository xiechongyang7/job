package com.seesea.job.entity;

public class ZhiHuPaging {

    /**
     *   "paging": {
     *     "is_end": false,
     *     "is_start": false,
     *     "next": "https://www.zhihu.com/api/v4/questions/39501641/answers?limit=20&offset=11340&sort_by=updated",
     *     "previous": "https://www.zhihu.com/api/v4/questions/39501641/answers?limit=20&offset=11260&sort_by=updated",
     *     "totals": 11342
     *   }
     */

    private String next;
    private String previous;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
