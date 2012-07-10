package org.phw.hbasedao.complex1;

import org.phw.hbasedao.annotations.HBaseTable;
import org.phw.hbasedao.annotations.HColumn;
import org.phw.hbasedao.annotations.HRowkey;

@HBaseTable(name = "complex1", autoCreate = true, families = { "f" })
public class Complex1 {
    @HRowkey
    private String rowkey;

    @HColumn
    private int age;
    @HColumn
    private String name;
    @HColumn
    private boolean adult;

    // ComplexBean因为没有实现ByteConvertable，将按照JSON进行存储。
    @HColumn
    private MyDay myday;

    @HColumn
    private OtherDay otherday;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (adult ? 1231 : 1237);
        result = prime * result + age;
        result = prime * result + (myday == null ? 0 : myday.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (rowkey == null ? 0 : rowkey.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Complex1 other = (Complex1) obj;
        if (adult != other.adult) {
            return false;
        }
        if (age != other.age) {
            return false;
        }
        if (myday == null) {
            if (other.myday != null) {
                return false;
            }
        }
        else if (!myday.equals(other.myday)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (rowkey == null) {
            if (other.rowkey != null) {
                return false;
            }
        }
        else if (!rowkey.equals(other.rowkey)) {
            return false;
        }
        return true;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public MyDay getMyday() {
        return myday;
    }

    public void setMyday(MyDay myday) {
        this.myday = myday;
    }

    public OtherDay getOtherday() {
        return otherday;
    }

    public void setOtherday(OtherDay otherday) {
        this.otherday = otherday;
    }

}
