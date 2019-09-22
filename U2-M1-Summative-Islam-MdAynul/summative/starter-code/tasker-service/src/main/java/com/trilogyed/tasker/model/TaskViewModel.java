package com.trilogyed.tasker.model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {
    private int id;
    @Size(max = 255,message = "Description out of Limit")
    private String description;
    @FutureOrPresent(message = "Create Date should be present or Future")
    private LocalDate createDate;
    @FutureOrPresent(message = "Due Date should be present or Future")
    private LocalDate dueDate;
    @Size(max = 50, message = "Category out of Limit")
    private String category;
    private String advertisement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    //Equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return id == that.id &&
                description.equals(that.description) &&
                createDate.equals(that.createDate) &&
                dueDate.equals(that.dueDate) &&
                category.equals(that.category) &&
                advertisement.equals(that.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category, advertisement);
    }
}
