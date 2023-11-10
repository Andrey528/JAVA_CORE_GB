package hw.hw1.controllers;

import hw.hw1.models.Note;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NoteController {
    public void writeToFile(String text) {
        Note note = new Note(text);
        String fileName = note.getTimestamp() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(note.getText());
            writer.newLine();
            System.out.println("Recorded successfully");
        } catch (IOException e) {
            System.out.println("Error while recorded");
            e.printStackTrace();
        }
    }
}
