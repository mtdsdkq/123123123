package com.dsq.chooseAddress.pojo;

public class Area {

    private Integer id;

    private String code;

    private Integer right;

    private Integer left;

    private String name;

    private Integer parent_id;

    private Byte level;

    public Area() {
    }

    public Area(Integer id, String code, Integer right, Integer left, String name, Integer parent_id, Byte level) {
        this.id = id;
        this.code = code;
        this.right = right;
        this.left = left;
        this.name = name;
        this.parent_id = parent_id;
        this.level = level;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }
}
