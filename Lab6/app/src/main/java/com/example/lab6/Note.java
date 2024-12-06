package com.example.lab6;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private final int id;
    private final String title;
    private final String content;

    private boolean isCompleted;

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    protected Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
    }

    //Это специальное поле, которое обязательно для всех классов, реализующих интерфейс
    // Parcelable. Оно служит фабрикой для создания объектов из Parcel

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
    }

    //Что это: Возвращает флаги для описания объекта. Обычно возвращается 0.
    //Зачем: Этот метод редко используется, но он обязателен для реализации интерфейса Parcelable.

    @Override
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
