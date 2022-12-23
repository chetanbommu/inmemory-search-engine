package model;

import java.time.LocalDate;

public class Document {
    private String text;
    private LocalDate createdAt;

    public Document(String text) {
        this.text = text;
        this.createdAt = LocalDate.now();
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Document {" +
                "text='" + text + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
