package com.fct.vos;

import java.util.List;

public class CollectionsVO {
    private List<String> ids;

    @Override
    public String toString() {
        return "CollectionsVO{" +
                "ids=" + ids +
                '}';
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
