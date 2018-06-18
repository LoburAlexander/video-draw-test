package com.videotracking.models.videotracking.domain;

import com.videotracking.models.utils.EntityUtils;

/**
 * Class, representing object capture within a video.<br/>
 * Contains information about object bounds:<br/>
 * 1) (x, y) - normalised coordinates within a video.<br/>
 * 2) (w, h) - normalised bounding rectangle size.<br/>
 *
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class ObjectCapture {
    public final float x;
    public final float y;
    public final float width;
    public final float height;


    public ObjectCapture(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @Override
    public int hashCode() {
        int hash = 13;
        int prime = 31;

        hash = prime * hash + EntityUtils.hashCode(x);
        hash = prime * hash + EntityUtils.hashCode(y);
        hash = prime * hash + EntityUtils.hashCode(width);
        hash = prime * hash + EntityUtils.hashCode(height);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || (obj.getClass() != this.getClass()))
            return false;

        ObjectCapture other = (ObjectCapture) obj;
        if (!EntityUtils.areEqual(x, other.x))
            return false;
        if (!EntityUtils.areEqual(y, other.y))
            return false;
        if (!EntityUtils.areEqual(width, other.width))
            return false;
        if (!EntityUtils.areEqual(height, other.height))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                EntityUtils.toStringField("x", x, false) +
                EntityUtils.toStringField("y", y, false) +
                EntityUtils.toStringField("width", width, false) +
                EntityUtils.toStringField("height", height, true) +
                "}";
    }
}
