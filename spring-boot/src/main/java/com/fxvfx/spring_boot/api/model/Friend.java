package com.fxvfx.spring_boot.api.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer numCats;
    private boolean canEatHeadOfLettuce;

    public Friend() {
        
    }

    public Friend(Integer id, String name, Integer numCats, Boolean canEatHeadOfLettuce) {
        this.id = id;
        this.name = name;
        this.numCats = numCats;
        this.canEatHeadOfLettuce = canEatHeadOfLettuce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getnumCats() {
        return numCats;
    }

    public void setnumCats(Integer numCats) {
        this.numCats = numCats;
    }

    public boolean isCanEatHeadOfLettuce() {
        return canEatHeadOfLettuce;
    }

    public void setCanEatHeadOfLettuce(boolean canEatHeadOfLettuce) {
        this.canEatHeadOfLettuce = canEatHeadOfLettuce;
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
        final Friend other = (Friend) obj;
        if (this.canEatHeadOfLettuce != other.canEatHeadOfLettuce) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.numCats, other.numCats);
    }

}
