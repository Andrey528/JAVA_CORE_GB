package hw.hw1.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private String text;
    private String timestamp;

    public Note(String text) {
        this.text = text;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String getText() {
        return text;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
